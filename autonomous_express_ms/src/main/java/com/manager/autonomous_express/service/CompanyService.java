package com.manager.autonomous_express.service;

import com.manager.autonomous_express.api.response.CompanyResponse;
import com.manager.autonomous_express.model.Company;
import com.manager.autonomous_express.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class CompanyService {
    private CompanyRepository companyRepository;

    //TODO: Procurar exceção correta para objeto não encontrado
    public List<CompanyResponse> findAll() {
        log.info("Looking for all companies");
        return companyRepository.findAll().stream().map(CompanyResponse::new).collect(Collectors.toList());
    }

    public CompanyResponse findById(UUID id) {
        Optional<Company> company = companyRepository.findById(id);
        if (company.isEmpty()) {
            throw new RuntimeException("Company not found by id");
        }
        return new CompanyResponse(company.get());
    }

    public CompanyResponse save(CompanyRequest request){
        log.info("Saving company");

        Company company = Company.builder()
                .name(request.getName())
                .cnpj(request.getCnpj())
                .logisticsCenterAddress(request.getLogisticsCenterAddress())
                .build();

        this.companyRepository.save(company);
        return new CompanyResponse(company);

}
}

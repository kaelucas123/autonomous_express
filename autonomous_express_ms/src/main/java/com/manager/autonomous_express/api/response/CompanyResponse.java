package com.manager.autonomous_express.api.response;

import com.manager.autonomous_express.model.Company;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyResponse {
    private String name;
    private String cnpj;
    private String logisticsCenterAddress;

    public CompanyResponse(Company company) {
        this.name = company.getName();
        this.cnpj = company.getCnpj();
        this.logisticsCenterAddress = company.getLogisticsCenterAddress();
    }
}

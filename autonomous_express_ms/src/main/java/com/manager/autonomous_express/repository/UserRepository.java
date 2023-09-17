package com.manager.autonomous_express.repository;

import com.manager.autonomous_express.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

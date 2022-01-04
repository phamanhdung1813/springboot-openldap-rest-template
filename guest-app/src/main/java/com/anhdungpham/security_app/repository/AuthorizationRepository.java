package com.anhdungpham.security_app.repository;

import com.anhdungpham.security_app.entity.AuthorizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorizationRepository extends JpaRepository<AuthorizationEntity, Long> {
    List<AuthorizationEntity> findByUsername(String username);
}

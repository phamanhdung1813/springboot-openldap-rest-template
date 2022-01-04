package com.anhdungpham.security_app.repository;

import com.anhdungpham.security_app.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
    UserEntity findByUsername(String username);
}

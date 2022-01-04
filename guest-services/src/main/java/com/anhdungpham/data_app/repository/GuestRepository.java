package com.anhdungpham.data_app.repository;

import com.anhdungpham.data_app.entity.GuestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<GuestEntity, Long> {
}

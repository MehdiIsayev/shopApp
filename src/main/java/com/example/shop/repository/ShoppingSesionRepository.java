package com.example.shop.repository;

import com.example.shop.entity.ShoppingSesion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingSesionRepository extends JpaRepository<ShoppingSesion, Long> {
    ShoppingSesion getShoppingSesionById(Long id);

}

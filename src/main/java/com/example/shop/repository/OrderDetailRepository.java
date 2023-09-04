package com.example.shop.repository;

import com.example.shop.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {
    OrderDetail getOrderDetailById(Long id);

}

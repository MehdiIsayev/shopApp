package com.example.shop.repository;

import com.example.shop.entity.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItems,Long> {
    OrderItems getOrderItemsById (Long id);


}

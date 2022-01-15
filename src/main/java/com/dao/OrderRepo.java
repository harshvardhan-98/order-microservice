package com.dao;

import com.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<OrderModel, Long> {
}

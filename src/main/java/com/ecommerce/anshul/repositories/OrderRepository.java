package com.ecommerce.anshul.repositories;

import com.ecommerce.anshul.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT COALESCE(SUM(o.totalAmount),0) FROM Order o")
    Double getTotalRevenue();

    List<Order> findByEmail(String email);
}

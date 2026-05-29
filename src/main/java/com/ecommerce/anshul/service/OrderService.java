package com.ecommerce.anshul.service;

import com.ecommerce.anshul.payload.OrderDTO;
import jakarta.transaction.Transactional;

import java.util.List;

public interface OrderService {
    @Transactional
    OrderDTO placeOrder(String emailId, Long addressId, String paymentMethod, String pgName, String pgPaymentId, String pgStatus, String pgResponseMessage);

    List<OrderDTO> getAllOrders();

    List<OrderDTO> getOrdersByEmail(String email);
}

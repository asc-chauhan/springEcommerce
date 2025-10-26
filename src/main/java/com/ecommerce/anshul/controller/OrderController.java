package com.ecommerce.anshul.controller;

import com.ecommerce.anshul.payload.OrderDTO;
import com.ecommerce.anshul.payload.OrderRequestDTO;
import com.ecommerce.anshul.service.OrderService;
import com.ecommerce.anshul.util.AuthUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private AuthUtil authUtil;

    @Tag(name = "Order API", description = "API for managing orders.")
    @PostMapping("/order/users/payments/{paymentMethod}")
    public ResponseEntity<OrderDTO> orderProducts(@PathVariable String paymentMethod,
                                                  @RequestBody OrderRequestDTO orderRequestDTO){
        String emailId = authUtil.loggedInEmail();
//        System.out.println("orderRequestDTO DATA: " + orderRequestDTO);
        OrderDTO order = orderService.placeOrder(
                emailId,
                orderRequestDTO.getAddressId(),
                paymentMethod,
                orderRequestDTO.getPgName(),
                orderRequestDTO.getPgPaymentId(),
                orderRequestDTO.getPgStatus(),
                orderRequestDTO.getPgResponseMessage()
        );
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
}

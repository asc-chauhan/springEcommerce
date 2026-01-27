package com.ecommerce.anshul.payload;

import com.ecommerce.anshul.model.Address;
import lombok.Data;

import java.util.Map;

@Data
public class StripePaymentDTO {
    private Long amount;
    private String currency;
    private String email;
    private String name;
    private Address address;
    private String description;
    private Map<String, String> metadata;
}

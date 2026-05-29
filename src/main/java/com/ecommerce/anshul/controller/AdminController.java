package com.ecommerce.anshul.controller;

import com.ecommerce.anshul.model.AppRole;
import com.ecommerce.anshul.model.User;
import com.ecommerce.anshul.repositories.UserRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @Tag(name = "Admin API", description = "API for admin operations.")
    @GetMapping("/admin/sellers")
    public ResponseEntity<List<Map<String, String>>> getAllSellers() {
        List<User> allUsers = userRepository.findAll();
        List<Map<String, String>> sellers = allUsers.stream()
                .filter(user -> user.getRoles().stream()
                        .anyMatch(role -> role.getRoleName() == AppRole.ROLE_SELLER))
                .map(user -> {
                    Map<String, String> sellerMap = new HashMap<>();
                    sellerMap.put("username", user.getUserName());
                    sellerMap.put("email", user.getEmail());
                    return sellerMap;
                })
                .collect(Collectors.toList());
        return new ResponseEntity<>(sellers, HttpStatus.OK);
    }
}

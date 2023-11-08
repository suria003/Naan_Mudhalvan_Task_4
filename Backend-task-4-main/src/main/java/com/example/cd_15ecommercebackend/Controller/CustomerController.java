package com.example.cd_15ecommercebackend.Controller;


import com.example.cd_15ecommercebackend.Service.CustomerServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerServices customerServices;


    @GetMapping("/getData/")
    public ResponseEntity<?> getData(){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return customerServices.getData(email);
    }

    @GetMapping("/getProducts/")
    public ResponseEntity<?> getProducts(){
        return customerServices.getProducts();
    }
}

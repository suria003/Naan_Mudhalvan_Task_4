package com.example.cd_15ecommercebackend;

import com.example.cd_15ecommercebackend.Service.MainSellerCreationService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class Cd15ECommerceBackendApplication {

    private final MainSellerCreationService mainSellerCreationService;

    public static void main(String[] args) {
        SpringApplication.run(Cd15ECommerceBackendApplication.class, args);
    }

    @PostConstruct
    public void init(){
        mainSellerCreationService.createAdmin();
    }

}

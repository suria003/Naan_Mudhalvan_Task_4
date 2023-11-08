package com.example.cd_15ecommercebackend.Controller;


import com.example.cd_15ecommercebackend.DTO.ProductDTO;
import com.example.cd_15ecommercebackend.Entity.Products;
import com.example.cd_15ecommercebackend.Service.SellerServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("/seller")
@RequiredArgsConstructor
public class SellerController {

    private final SellerServices sellerServices;

    @PostMapping("/add/")
    public ResponseEntity<?> add(@RequestParam("file") MultipartFile file, @RequestParam("data") String dataString) throws IOException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ProductDTO productDTO = objectMapper.readValue(dataString, ProductDTO.class);
            return sellerServices.addProduct(file, productDTO);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

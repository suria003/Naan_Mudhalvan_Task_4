package com.example.cd_15ecommercebackend.Service;


import com.example.cd_15ecommercebackend.DAO.ProductDAO;
import com.example.cd_15ecommercebackend.DTO.ProductDTO;
import com.example.cd_15ecommercebackend.Entity.Products;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class SellerServices {

    private final ProductDAO productDAO;
    public ResponseEntity<?> addProduct(MultipartFile file, ProductDTO productDTO) throws IOException {
        String fileName = System.currentTimeMillis()+"."+file.getContentType().split("/")[1];
        Path filePath = Paths.get("src/main/resources/static",fileName);
        Files.write(filePath,file.getBytes());

        Products products = Products.builder()
                .name(productDTO.getName())
                .description(productDTO.getDescription())
                .price(productDTO.getPrice())
                .imageSrc(fileName)
                .build();

        return new ResponseEntity<>(productDAO.save(products), HttpStatus.OK);


    }
}

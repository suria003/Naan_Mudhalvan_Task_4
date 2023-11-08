package com.example.cd_15ecommercebackend.Entity;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document("Products")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Products {


    private String id;
    private String name;
    private String description;
    private String imageSrc;
    private Double price;


}

package com.example.cd_15ecommercebackend.DTO;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    private String imageSrc;
    @JsonProperty("price")
    private Double price;

}

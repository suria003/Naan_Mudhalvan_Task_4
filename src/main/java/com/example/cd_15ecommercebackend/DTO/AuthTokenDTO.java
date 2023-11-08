package com.example.cd_15ecommercebackend.DTO;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthTokenDTO {
    private String authToken;
    private String refreshToken;
}

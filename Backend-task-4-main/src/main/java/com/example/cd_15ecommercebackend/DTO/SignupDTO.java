package com.example.cd_15ecommercebackend.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupDTO {

    private String name;
    private String email;
    private String password;
    private Long phoneNumber;
}

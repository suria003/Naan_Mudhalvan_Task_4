package com.example.cd_15ecommercebackend.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("Orders")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Orders {
    private String id;
    private List<Products> productsList;
    private UsersEntity usersEntity;
    private String address;
}

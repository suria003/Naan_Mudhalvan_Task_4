package com.example.cd_15ecommercebackend.Service;


import com.example.cd_15ecommercebackend.DAO.UserDAO;
import com.example.cd_15ecommercebackend.Entity.UsersEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.cd_15ecommercebackend.Entity.Role;

import java.util.List;

@Service
@AllArgsConstructor
public class MainSellerCreationService {
    private final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;
    public void createAdmin(){
        DeleteFiles d = new DeleteFiles();
        if(!ifAdminExist()){
            d.run();
            UsersEntity usersEntity = UsersEntity.builder()
                    .name("ADMIN")
                    .email("admin@gmail.com")
                    .password(passwordEncoder.encode("admin"))
                    .role(Role.SELLER)
                    .build();

            userDAO.save(usersEntity);
        }
    }

    private boolean ifAdminExist(){
        List<UsersEntity> usersEntity = userDAO.findByRole(Role.SELLER);
        return !usersEntity.isEmpty();
    }
}

package com.example.cd_15ecommercebackend.DAO;


import com.example.cd_15ecommercebackend.Entity.Role;
import com.example.cd_15ecommercebackend.Entity.UsersEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserDAO extends MongoRepository<UsersEntity,String> {
    List<UsersEntity> findByRole(Role role);
    UsersEntity findByEmail(String email);
    List<UsersEntity> findAllByRole(Role role);
}

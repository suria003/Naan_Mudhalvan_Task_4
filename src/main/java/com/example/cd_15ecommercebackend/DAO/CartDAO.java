package com.example.cd_15ecommercebackend.DAO;

import com.example.cd_15ecommercebackend.Entity.Cart;
import com.example.cd_15ecommercebackend.Entity.UsersEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartDAO extends MongoRepository<Cart,String> {
    Cart findByUsersEntity(UsersEntity byEmail);
}

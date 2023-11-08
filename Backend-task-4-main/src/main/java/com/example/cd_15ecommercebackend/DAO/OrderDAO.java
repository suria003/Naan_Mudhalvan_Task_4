package com.example.cd_15ecommercebackend.DAO;

import com.example.cd_15ecommercebackend.Entity.Orders;
import com.example.cd_15ecommercebackend.Entity.UsersEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderDAO extends MongoRepository<Orders,String> {
    List<Orders> findByUsersEntity(UsersEntity usersEntity);
}

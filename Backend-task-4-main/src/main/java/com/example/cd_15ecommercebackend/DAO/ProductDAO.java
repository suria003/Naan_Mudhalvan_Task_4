package com.example.cd_15ecommercebackend.DAO;

import com.example.cd_15ecommercebackend.Entity.Products;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductDAO extends MongoRepository<Products,String> {
}

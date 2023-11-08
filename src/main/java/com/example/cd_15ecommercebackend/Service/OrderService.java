package com.example.cd_15ecommercebackend.Service;


import com.example.cd_15ecommercebackend.DAO.CartDAO;
import com.example.cd_15ecommercebackend.DAO.OrderDAO;
import com.example.cd_15ecommercebackend.DAO.UserDAO;
import com.example.cd_15ecommercebackend.Entity.Cart;
import com.example.cd_15ecommercebackend.Entity.Orders;
import com.example.cd_15ecommercebackend.Entity.Products;
import com.example.cd_15ecommercebackend.Entity.UsersEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderDAO orderDAO;
    private final UserDAO userDAO;
    private final CartDAO cartDAO;


    public ResponseEntity<?> OrderProduct(String email,String address){
        UsersEntity usersEntity = userDAO.findByEmail(email);
        Cart cart = cartDAO.findByUsersEntity(usersEntity);
        if(cart==null){
            return new ResponseEntity<>("The Cart is Empty", HttpStatus.BAD_REQUEST);
        }
        else{
            List<Products> productsList = new ArrayList<>(cart.getProductsList());
            Orders orders = Orders.builder()
                    .productsList(productsList)
                    .usersEntity(usersEntity)
                    .address(address)
                    .build();
            orderDAO.save(orders);
            cartDAO.deleteById(cart.getId());

            return new ResponseEntity<>("Your Order Has Been Placed", HttpStatus.OK);
        }
    }

    public ResponseEntity<?> getOrders(String email){
        UsersEntity usersEntity = userDAO.findByEmail(email);
        List<Orders> ordersList = orderDAO.findByUsersEntity(usersEntity);
        return new ResponseEntity<>(ordersList,HttpStatus.OK);
    }


}

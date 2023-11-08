package com.example.cd_15ecommercebackend.Service;


import com.example.cd_15ecommercebackend.DAO.CartDAO;
import com.example.cd_15ecommercebackend.DAO.ProductDAO;
import com.example.cd_15ecommercebackend.DAO.UserDAO;
import com.example.cd_15ecommercebackend.Entity.Cart;
import com.example.cd_15ecommercebackend.Entity.Products;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartDAO cartDAO;
    private final ProductDAO productDAO;
    private final UserDAO userDAO;

    public ResponseEntity<?> addToCart(String id,String email){
        Optional<Products> optionalProducts = productDAO.findById(id);
        if(optionalProducts.isPresent()){
            Products products = optionalProducts.get();
            Cart cart = cartDAO.findByUsersEntity(userDAO.findByEmail(email));
            if(cart==null){
                cart = Cart.builder()
                        .usersEntity(userDAO.findByEmail(email))
                        .productsList(new ArrayList<>())
                        .build();
            }
            List<Products> productsList = cart.getProductsList();
            if(productsList.contains(products)){
                return new ResponseEntity<>("The Product All Ready in the Cart",HttpStatus.OK);
            }
            else{
                productsList.add(products);
                cart.setProductsList(productsList);
            }
            cartDAO.save(cart);
            return new ResponseEntity<>("The Product Added to the Cart",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<?> removeFromCart(String id,String email){
        Optional<Products> optionalProducts = productDAO.findById(id);
        if(optionalProducts.isPresent()){
            Products products = optionalProducts.get();
            Cart cart = cartDAO.findByUsersEntity(userDAO.findByEmail(email));
            if(cart==null){
                cart = Cart.builder()
                        .usersEntity(userDAO.findByEmail(email))
                        .productsList(new ArrayList<>())
                        .build();
            }
            List<Products> productsList = cart.getProductsList();
            if(!productsList.contains(products)){
                return new ResponseEntity<>("The Product Not in your Cart",HttpStatus.OK);
            }
            else{
                productsList.remove(products);
                cart.setProductsList(productsList);
            }
            cartDAO.save(cart);
            return new ResponseEntity<>("The Product Successfully removed from your Cart",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<?> getCartList(String email){
        Cart cart = cartDAO.findByUsersEntity(userDAO.findByEmail(email));
        if(cart==null){
            cart = Cart.builder()
                    .usersEntity(userDAO.findByEmail(email))
                    .productsList(new ArrayList<>())
                    .build();
        }

        return new ResponseEntity<>(cart.getProductsList(),HttpStatus.OK);
    }




}

package com.example.cd_15ecommercebackend.Service;


import com.example.cd_15ecommercebackend.DAO.ProductDAO;
import com.example.cd_15ecommercebackend.DAO.UserDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServices {

    private final UserDAO userDAO;
    private final ProductDAO productDAO;

    public ResponseEntity<?> getData(String email){
        return new ResponseEntity<>(userDAO.findByEmail(email), HttpStatus.OK);
    }


    public ResponseEntity<?> getProducts(){
        return new ResponseEntity<>(productDAO.findAll(),HttpStatus.OK);
    }
}

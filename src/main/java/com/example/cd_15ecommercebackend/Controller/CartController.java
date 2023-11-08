package com.example.cd_15ecommercebackend.Controller;

import com.example.cd_15ecommercebackend.Service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    @GetMapping("/add/{id}")
    public ResponseEntity<?> addToCart(@PathVariable String id){
        return cartService.addToCart(id, SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @GetMapping("/remove/{id}")
    public ResponseEntity<?> removeFromCart(@PathVariable String id){
        return cartService.removeFromCart(id,SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @GetMapping("/getAllProducts/")
    public ResponseEntity<?> getAllProducts(){
        return cartService.getCartList(SecurityContextHolder.getContext().getAuthentication().getName());
    }


//
//    @PostMapping("/proceedToBuy/")
//    public ResponseEntity<?> proceedToBuy(@RequestBody List<Products> productsList){
//
//
//
//    }




}

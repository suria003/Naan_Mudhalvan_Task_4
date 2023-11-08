package com.example.cd_15ecommercebackend.Controller;


import com.example.cd_15ecommercebackend.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrdersController {

    private final OrderService orderService;

    @GetMapping("/placeOrder/{address}")
    public ResponseEntity<?> placeOrder(@PathVariable String address){
        return orderService.OrderProduct(SecurityContextHolder.getContext().getAuthentication().getName(),address);
    }

    @GetMapping("/getHistory/")
    public  ResponseEntity<?> getData(){
        return orderService.getOrders(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}

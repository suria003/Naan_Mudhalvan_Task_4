package com.example.cd_15ecommercebackend.Controller;


import com.example.cd_15ecommercebackend.DTO.SignupDTO;
import com.example.cd_15ecommercebackend.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/create/")
    public ResponseEntity<?> signup(@RequestBody SignupDTO signupDTO){
        return authService.createNewUser(signupDTO);
    }

    @PostMapping("/login/")
    public ResponseEntity<?> login(@RequestBody SignupDTO signupDTO){
        return authService.loginUser(signupDTO);
    }


}

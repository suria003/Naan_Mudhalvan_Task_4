package com.example.cd_15ecommercebackend.Service;


import com.example.cd_15ecommercebackend.DAO.UserDAO;
import com.example.cd_15ecommercebackend.DTO.AuthTokenDTO;
import com.example.cd_15ecommercebackend.DTO.SignupDTO;
import com.example.cd_15ecommercebackend.Entity.Role;
import com.example.cd_15ecommercebackend.Entity.UsersEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;
    private final JwtServices jwtServices;


    public ResponseEntity<?> createNewUser(SignupDTO userDTO) {

        try {
            UsersEntity usersEntity = UsersEntity.builder()
                    .role(Role.CUSTOMER)
                    .name(userDTO.getName())
                    .email(userDTO.getEmail())
                    .password(passwordEncoder.encode(userDTO.getPassword()))
                    .phoneNumber(userDTO.getPhoneNumber())
                    .build();
            userDAO.save(usersEntity);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    public ResponseEntity<?> loginUser(SignupDTO userDTO) {
        try {
            UsersEntity usersEntity = userDAO.findByEmail(userDTO.getEmail());
            if (usersEntity == null) {
                return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
            }
            try {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDTO.getEmail(), userDTO.getPassword()));
                AuthTokenDTO authTokenDTO = AuthTokenDTO.builder()
                        .authToken(jwtServices.getJwtToken(usersEntity))
                        .refreshToken(jwtServices.getRefreshToken(usersEntity))
                        .build();
                return new ResponseEntity<>(authTokenDTO, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>("Invalid Access Credentials", HttpStatus.FORBIDDEN);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

}

package com.example.cd_15ecommercebackend.Service;

import com.example.cd_15ecommercebackend.DAO.UserDAO;
import com.example.cd_15ecommercebackend.Entity.UsersEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LoadUserService implements UserDetailsService {

    private final UserDAO userDAO;
    @Override
    public UserDetails loadUserByUsername(String username){
        UsersEntity usersEntity = userDAO.findByEmail(username);
        if(usersEntity==null){
            throw new UsernameNotFoundException("User Not Found");
        }
        else{
            return usersEntity;
        }
    }
}

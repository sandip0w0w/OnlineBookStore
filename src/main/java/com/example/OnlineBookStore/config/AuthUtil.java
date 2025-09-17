package com.example.OnlineBookStore.config;

import com.example.OnlineBookStore.model.User;
import com.example.OnlineBookStore.model.UserPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthUtil {

    public User getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !(authentication.getPrincipal() instanceof UserPrincipal userPrincipal)) {
            throw new IllegalStateException("No authenticated user found");
        }
        return userPrincipal.getUser();
    }
}

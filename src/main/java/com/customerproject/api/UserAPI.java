package com.customerproject.api;

import com.customerproject.dto.UserDTO;
import com.customerproject.security.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "userAPI")
public class UserAPI {
    @Autowired
    private AuthService authService;

    @PostMapping(value = "/api/register")
    public UserDTO register(@RequestBody UserDTO user){
        return authService.register(user);
    }

    @PostMapping(value = "/api/login")
    public String login(@RequestBody UserDTO user){
        return authService.verify(user);
    }
}

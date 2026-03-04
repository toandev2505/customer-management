package com.customerproject.security;

import com.customerproject.constant.SystemConstant;
import com.customerproject.converter.UserConverter;
import com.customerproject.dto.UserDTO;
import com.customerproject.entity.UserEntity;
import com.customerproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(SystemConstant.PASSWORD_STRENGHT);

    public UserDTO register(UserDTO user){
        UserEntity entity = userConverter.toEntity(user);
        entity.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        UserEntity result = userRepository.save(entity);
        return userConverter.toDTO(result);
    }

    public String verify(UserDTO user) {
        UserEntity entity = userConverter.toEntity(user);
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(entity.getUserName(), entity.getPassword()));
        if (authentication.isAuthenticated()){
            return jwtService.generateToken(entity.getUserName());
        }
        return "fail";
    }
}

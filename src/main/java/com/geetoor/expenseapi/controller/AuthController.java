package com.geetoor.expenseapi.controller;

import com.geetoor.expenseapi.dto.JWTResponse;
import com.geetoor.expenseapi.dto.user.RequestLogin;
import com.geetoor.expenseapi.dto.user.RequestUser;
import com.geetoor.expenseapi.entity.User;
import com.geetoor.expenseapi.security.CustomUserDetailsService;
import com.geetoor.expenseapi.service.UserService;
import com.geetoor.expenseapi.util.JWTTokenUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private UserService userService;
    private AuthenticationManager authenticationManager;
    private CustomUserDetailsService customUserDetailsService;
    private JWTTokenUtil jwtTokenUtil;

    @Autowired
    public AuthController(UserService userService, AuthenticationManager authenticationManager, CustomUserDetailsService customUserDetailsService, JWTTokenUtil jwtTokenUtil) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.customUserDetailsService = customUserDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping(
            path = "/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<JWTResponse> login(@RequestBody RequestLogin login)throws Exception{
        authenticate(login.getEmail(), login.getPassword());

        final UserDetails userDetails =customUserDetailsService.loadUserByUsername(login.getEmail());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return new ResponseEntity<JWTResponse>(new JWTResponse(token) ,HttpStatus.OK);
    }

    private void authenticate(String email, String password) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password ));
        }catch (DisabledException ex){
            throw new Exception("User Disable");
        }catch (BadCredentialsException ex){
            throw new Exception("Bad Credeantials");
        }
    }

    @PostMapping(
            path = "/register",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<User> save(@Valid @RequestBody RequestUser model){
        return new ResponseEntity<User>(userService.createUser(model), HttpStatus.CREATED);
    }
}

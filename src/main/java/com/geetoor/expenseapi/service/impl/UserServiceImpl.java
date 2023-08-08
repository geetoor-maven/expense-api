package com.geetoor.expenseapi.service.impl;

import com.geetoor.expenseapi.dto.user.RequestUser;
import com.geetoor.expenseapi.entity.User;
import com.geetoor.expenseapi.exception.ItemAlreadyExistException;
import com.geetoor.expenseapi.exception.ResourceNotFoundException;
import com.geetoor.expenseapi.repository.UserRepository;
import com.geetoor.expenseapi.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @Override
    public User createUser(RequestUser requestUser) {
        if (userRepository.existsByEmail(requestUser.getEmail())){
            throw new ItemAlreadyExistException("User is al ready register with email : " + requestUser.getEmail());
        }
        User user = new User();
        BeanUtils.copyProperties(requestUser, user);

        user.setUserId(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }


    @Override
    public User readUserById() {
        String user = getLoggedInUser().getUserId();
        return userRepository.findById(user).orElseThrow(() -> new ResourceNotFoundException("user not found"));
    }

    @Transactional
    @Override
    public User updateUser(RequestUser requestUser) {

        if (userRepository.existsByEmail(requestUser.getEmail())){
            throw new ItemAlreadyExistException("User is al ready register with email : " + requestUser.getEmail());
        }

        User user = readUserById();
        user.setName(requestUser.getName() != null ? requestUser.getName() : user.getName());
        user.setEmail(requestUser.getEmail() != null ? requestUser.getEmail() : user.getEmail());
        user.setPassword(requestUser.getPassword() != null ? passwordEncoder.encode(requestUser.getPassword()) : user.getPassword());
        user.setAge(requestUser.getAge() != null ? requestUser.getAge() : user.getAge());

        return userRepository.save(user);
    }

    @Transactional
    @Override
    public void deleteUser() {
        User user = readUserById();
        userRepository.delete(user);
    }

    @Override
    public User getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        return userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }
}

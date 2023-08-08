package com.geetoor.expenseapi.service;

import com.geetoor.expenseapi.dto.user.RequestUser;
import com.geetoor.expenseapi.entity.User;

public interface UserService {
    User createUser(RequestUser requestUser);
    User readUserById();
    User updateUser(RequestUser requestUser);
    void deleteUser();
    User getLoggedInUser();
}

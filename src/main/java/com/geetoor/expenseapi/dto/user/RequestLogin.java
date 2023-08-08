package com.geetoor.expenseapi.dto.user;

import lombok.Data;

@Data
public class RequestLogin {
    private String email;
    private String password;
}

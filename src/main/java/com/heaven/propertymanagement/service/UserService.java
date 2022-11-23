package com.heaven.propertymanagement.service;

import com.heaven.propertymanagement.dto.UserDTO;

public interface UserService {
    UserDTO register(UserDTO userDTO);
    UserDTO login(String email,String password);
}

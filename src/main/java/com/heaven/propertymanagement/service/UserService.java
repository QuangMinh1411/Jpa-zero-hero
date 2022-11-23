package com.heaven.propertymanagement.service;

import com.heaven.propertymanagement.dto.UserDTO;
import com.heaven.propertymanagement.exception.BusinessException;

public interface UserService {
    UserDTO register(UserDTO userDTO);
    UserDTO login(String email,String password) throws BusinessException;
}

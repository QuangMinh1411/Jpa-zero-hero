package com.heaven.propertymanagement.service.impl;

import com.heaven.propertymanagement.convertor.UserConvertor;
import com.heaven.propertymanagement.dto.UserDTO;
import com.heaven.propertymanagement.entity.UserEntity;
import com.heaven.propertymanagement.repository.UserRepository;
import com.heaven.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConvertor userConvertor;
    @Override
    public UserDTO register(UserDTO userDTO) {
        UserEntity userEntity = userConvertor.convertDTOtoEntity(userDTO);
        userEntity = userRepository.save(userEntity);
        userDTO = userConvertor.convertEntitytoDTO(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {
        return null;
    }
}

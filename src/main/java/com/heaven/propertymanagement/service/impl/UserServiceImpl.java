package com.heaven.propertymanagement.service.impl;

import com.heaven.propertymanagement.convertor.UserConvertor;
import com.heaven.propertymanagement.dto.UserDTO;
import com.heaven.propertymanagement.entity.UserEntity;
import com.heaven.propertymanagement.exception.BusinessException;
import com.heaven.propertymanagement.exception.ErrorModel;
import com.heaven.propertymanagement.repository.UserRepository;
import com.heaven.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConvertor userConvertor;
    @Override
    public UserDTO register(UserDTO userDTO) {
        Optional<UserEntity> optionalUser = userRepository.findByOwnerEmail(userDTO.getOwnerEmail());
        if(optionalUser.isPresent()){
            List<ErrorModel> errors = new ArrayList<>();
            errors.add(new ErrorModel("USER_EXISTED","User email is existed"));
            throw new BusinessException(errors);
        }
        UserEntity userEntity = userConvertor.convertDTOtoEntity(userDTO);
        userEntity = userRepository.save(userEntity);
        userDTO = userConvertor.convertEntitytoDTO(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {
        UserDTO userDTO = null;
       Optional<UserEntity> optionalUser= userRepository.findByOwnerEmailAndPassword(email,password);
      if(optionalUser.isPresent()){
        userDTO = userConvertor.convertEntitytoDTO(optionalUser.get());
      }else {
          List<ErrorModel> errors = new ArrayList<>();
          errors.add(new ErrorModel("INVALID_LOGIN","Incorrect email or password"));
          throw new BusinessException(errors);
      }
        return userDTO;
    }
}

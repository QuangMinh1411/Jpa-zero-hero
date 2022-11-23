package com.heaven.propertymanagement.convertor;

import com.heaven.propertymanagement.dto.UserDTO;
import com.heaven.propertymanagement.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConvertor {
    public UserEntity convertDTOtoEntity(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        userEntity.setOwnerName(userDTO.getOwnerName());
        userEntity.setOwnerEmail(userDTO.getOwnerEmail());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setPhone(userDTO.getPhone());
        return userEntity;
    }
    public UserDTO convertEntitytoDTO(UserEntity userEntity){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setOwnerEmail(userEntity.getOwnerEmail());
        userDTO.setOwnerName(userEntity.getOwnerName());
        userDTO.setPhone(userEntity.getPhone());
        return userDTO;
    }
}

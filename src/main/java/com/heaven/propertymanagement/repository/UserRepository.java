package com.heaven.propertymanagement.repository;

import com.heaven.propertymanagement.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity,Long> {
}

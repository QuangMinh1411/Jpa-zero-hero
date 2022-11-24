package com.heaven.propertymanagement.repository;

import com.heaven.propertymanagement.entity.AddressEntity;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<AddressEntity,Long> {
}

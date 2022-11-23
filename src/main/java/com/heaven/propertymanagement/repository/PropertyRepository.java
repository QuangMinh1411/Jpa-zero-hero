package com.heaven.propertymanagement.repository;

import com.heaven.propertymanagement.entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRepository extends CrudRepository<PropertyEntity,Long> {
}

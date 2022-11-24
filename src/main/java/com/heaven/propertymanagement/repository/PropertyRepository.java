package com.heaven.propertymanagement.repository;

import com.heaven.propertymanagement.entity.PropertyEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PropertyRepository extends CrudRepository<PropertyEntity,Long> {
    @Query("select p from PropertyEntity p where p.userEntity.id=?1")
    List<PropertyEntity> findAllByUserEntityId(Long userId);
}

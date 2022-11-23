package com.heaven.propertymanagement.controller;

import com.heaven.propertymanagement.dto.PropertyDTO;
import com.heaven.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {
    @Value("${data.dummy:}")
    private String dummy;
    @Autowired
    private PropertyService propertyService;

    @PostMapping("/properties")
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO){
        PropertyDTO dto = propertyService.saveProperty(propertyDTO);
        System.out.println(propertyDTO);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("/properties")
    public ResponseEntity<?> getAllProperties(){
        System.out.println(dummy);
        List<PropertyDTO> propertyList = propertyService.getAllProperties();
        return new ResponseEntity<>(propertyList,HttpStatus.OK);

    }
    @PutMapping("/properties/{id}")
    public ResponseEntity<?> updateProperty(@RequestBody PropertyDTO propertyDTO,@PathVariable("id") Long id){
        return new ResponseEntity<>(propertyService.updateProperty(propertyDTO,id),HttpStatus.OK);
    }
    @PatchMapping("/properties/update_description/{id}")
    public ResponseEntity<?> updateDescription(@RequestBody PropertyDTO propertyDTO,@PathVariable Long id){
        return new ResponseEntity<>(propertyService.updateDescription(propertyDTO,id),HttpStatus.OK);
    }

    @PatchMapping("/properties/update_price/{id}")
    public ResponseEntity<?> updatePrice(@RequestBody PropertyDTO propertyDTO,@PathVariable Long id){
        return new ResponseEntity<>(propertyService.updatePrice(propertyDTO,id),HttpStatus.OK);
    }
    @DeleteMapping("/properties/{id}")
    public ResponseEntity<?> deleteProperty(@PathVariable Long id){
        propertyService.deleteProperty(id);
        return ResponseEntity.noContent().build();
    }
}

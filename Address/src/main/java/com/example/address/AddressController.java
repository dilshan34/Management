package com.example.address;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/address/{emp_id}")
    public ResponseEntity<AddressResponse> getAddress(@PathVariable("emp_id") int id){

        AddressResponse entity = addressService.getAddress(id);
        return ResponseEntity.status(HttpStatus.OK).body(entity) ;

    }
}

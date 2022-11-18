package com.example.address;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    AddressRepository repository;

    @Autowired
    ModelMapper modelMapper;

    public AddressResponse getAddress(int id){

        AddressEntity addressEntity = repository.findById(id).get();
        AddressResponse addressResponse = modelMapper.map(addressEntity,AddressResponse.class);

        System.out.println(addressResponse.getState());
        return  addressResponse;
    }
}

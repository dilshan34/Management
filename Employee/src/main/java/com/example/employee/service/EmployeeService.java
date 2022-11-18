package com.example.employee.service;

import com.example.employee.model.EmployeeEntity;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.response.AddressResponse;
import com.example.employee.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeService {


    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
     ModelMapper mapper;
//    @Autowired
//    WebClient webClient;
    @Autowired
    RestTemplate restTemplate;
//
//    public EmployeeService(@Value("${addressservice.base.url}") String url, RestTemplateBuilder builder){
//
//        this.restTemplate = builder
//                .rootUri(url)
//                .build();
//        System.out.println("url"+  this.restTemplate);
//    }

//    @Value("${addressservice.base.url}")
//    private String url;

    public EmployeeResponse getUserById(int id) {

        //get data from db
        EmployeeEntity emp = employeeRepository.findById(id).get();

        System.out.println(emp.getEmail());

        //set data to the model
        EmployeeResponse response = mapper.map(emp, EmployeeResponse.class);

        //get data from another service busing rest emplate
         AddressResponse  addressResponse = restTemplate.getForObject("http://localhost:8081/address/{id}",AddressResponse.class,id);


        //get data from another service using webflux/reactive web
//        AddressResponse addressResponse = webClient
//                .get().uri("http://localhost:8081/address" + id).retrieve().bodyToMono(AddressResponse.class).block();

        //set data to the AddressResponse model
        response.setAddressResponse(addressResponse);

        return response;
    }


}

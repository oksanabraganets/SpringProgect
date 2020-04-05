package com.example.simple.service;

import com.example.simple.dto.RequestsDTO;
import com.example.simple.repositary.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final RequestRepository requestRepository;

    @Autowired
    public AdminService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }


    public RequestsDTO getCreditRequests(){
        RequestsDTO requestsDTO = RequestsDTO.builder()
                .firstName(UserService.getCurrentUser().getFirstName())
                .lastName(UserService.getCurrentUser().getLastName())
                .requests(requestRepository.findAll())
                .build();
        System.out.println(requestsDTO);
        return requestsDTO;
    }
}

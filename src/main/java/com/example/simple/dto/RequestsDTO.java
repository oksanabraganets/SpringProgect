package com.example.simple.dto;

import com.example.simple.entity.RequestDAO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RequestsDTO {
    private String firstName;
    private String lastName;
    List<RequestDAO> requests;
}

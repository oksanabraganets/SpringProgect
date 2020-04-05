package com.example.simple.dto;

import com.example.simple.entity.AccountDAO;
import com.example.simple.entity.BillDAO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class BillsDTO {
    private String firstName;
    private String lastName;
    List<BillDAO> bills;
    List<AccountDAO> accounts;
}

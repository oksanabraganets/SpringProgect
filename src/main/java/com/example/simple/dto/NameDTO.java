package com.example.simple.dto;

import com.example.simple.entity.AccountDAO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class NameDTO {
    private String firstName;
    private String lastName;
    private String date;
    private List<AccountDAO> accounts;
    private List<AccountDAO> allAccounts;
}

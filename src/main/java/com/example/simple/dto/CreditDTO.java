package com.example.simple.dto;

import com.example.simple.entity.AccountDAO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CreditDTO {
    private String firstName;
    private String lastName;
    private boolean creditExists;
    private AccountDAO credit;
}

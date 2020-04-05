package com.example.simple.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PaymentDTO {
    Long billId;
    Long accountId;
}

package com.example.simple.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TransferDTO {
    Long fromId;
    Long toId;
    Long amount;
}

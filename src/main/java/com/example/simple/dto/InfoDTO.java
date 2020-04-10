package com.example.simple.dto;

import java.util.List;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class InfoDTO {

    List<ViewElement> viewElements;
    boolean showReplenishment;

}

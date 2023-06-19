package com.example.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CarDto {

    Integer id;

    String brand;

    Integer kilowatt;

}

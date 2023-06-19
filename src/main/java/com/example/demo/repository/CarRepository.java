package com.example.demo.repository;

import com.example.demo.entity.CarEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface CarRepository extends R2dbcRepository<CarEntity, Integer> {


}

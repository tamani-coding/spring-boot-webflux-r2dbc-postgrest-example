package com.example.demo.service.impl;

import com.example.demo.dto.CarDto;
import com.example.demo.entity.CarEntity;
import com.example.demo.repository.CarRepository;
import com.example.demo.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Override
    public Mono<CarDto> getCar(Integer carId) {
        return carRepository
                .findById(carId)
                .map(carEntity -> CarDto.builder()
                        .id(carEntity.getId())
                        .brand(carEntity.getBrand())
                        .kilowatt(carEntity.getKilowatt())
                        .build());
    }

    @Override
    public Mono<CarDto> createCar(CarDto carDto) {
        return carRepository.save(CarEntity.builder()
                        .brand(carDto.getBrand())
                        .kilowatt(carDto.getKilowatt())
                        .build())
                .map(carEntity -> CarDto.builder()
                        .id(carEntity.getId())
                        .brand(carEntity.getBrand())
                        .kilowatt(carEntity.getKilowatt())
                        .build());
    }

    @Override
    public Mono<CarDto> updateCar(Integer carId, CarDto carDto) {
        carDto.setId(carId);
        return carRepository.save(CarEntity.builder()
                        .id(carDto.getId())
                        .brand(carDto.getBrand())
                        .kilowatt(carDto.getKilowatt())
                        .build())
                .map(carEntity -> CarDto.builder()
                        .id(carEntity.getId())
                        .brand(carEntity.getBrand())
                        .kilowatt(carEntity.getKilowatt())
                        .build());
    }

    @Override
    public Mono<Void> deleteCar(Integer carId) {
        return carRepository.delete(CarEntity.builder()
                .id(carId)
                .build());
    }

    @Override
    public Flux<CarDto> getAllCars() {
        return carRepository.findAll().map(carEntity -> CarDto.builder()
                .id(carEntity.getId())
                .brand(carEntity.getBrand())
                .kilowatt(carEntity.getKilowatt())
                .build());
    }
}

package com.Product_management_appli.ProductManagementAppli.mappers;

import com.Product_management_appli.ProductManagementAppli.dtos.CarRequestDTO;
import com.Product_management_appli.ProductManagementAppli.entity.Car;

public class CarMapper {
    public static Car CarDtoToCar(CarRequestDTO carRequestDTO){

        Car car = new Car();
        car.setBrand(carRequestDTO.getBrand());
        car.setModel(carRequestDTO.getModel());
        car.setPrice(carRequestDTO.getPrice());
        return car;
    }

    public static CarRequestDTO CarToCarDto(Car car){
        CarRequestDTO carRequestDTO = new CarRequestDTO();
        carRequestDTO.setBrand(car.getBrand());
        carRequestDTO.setModel(car.getModel());
        carRequestDTO.setPrice(car.getPrice());
        return carRequestDTO;
    }


}

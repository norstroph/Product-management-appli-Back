package com.Product_management_appli.ProductManagementAppli.services;

import com.Product_management_appli.ProductManagementAppli.DAOorRepository.CarDAO;
import com.Product_management_appli.ProductManagementAppli.dtos.CarRequestDTO;
import com.Product_management_appli.ProductManagementAppli.entity.Car;
import com.Product_management_appli.ProductManagementAppli.exception.NotFoundHandlerException;
import com.Product_management_appli.ProductManagementAppli.mappers.CarMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarDAO carDAO;

    public CarService(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public List<Car> findAllCar() {
        List<Car> cars = carDAO.findAllCar();
        return cars;
    }


    public List<CarRequestDTO> findCarByModel(String model) {
        List<Car> cars = carDAO.findCarByModel(model);
        if (cars.isEmpty()) {
            throw new NotFoundHandlerException("Aucune voiture trouvée pour le modèle : " + model);
        }
        return cars.stream()
                .map(CarMapper::CarToCarDto)
                .toList();
    }

    // TODO : VOIR COMMENT NE PAS REPETER CETTE ET REFACTO EN 1
    public List<CarRequestDTO> findCarByBrand(String brand) {
        List<Car> cars = carDAO.findCarByBrand(brand);
        if (cars.isEmpty()) {
            throw new NotFoundHandlerException("Aucune voiture trouvée pour le brand : " + brand);
        }
        return cars.stream()
                .map(CarMapper::CarToCarDto)
                .toList();
    }

    public CarRequestDTO saveCar(CarRequestDTO carRequestDTO) {
        Car car = CarMapper.CarDtoToCar(carRequestDTO);
        Car saveCard = carDAO.saveCar(car);
        CarRequestDTO carDTO = CarMapper.CarToCarDto(saveCard);
        return carDTO;
    }

    public Car updateCar(Car car) {
        return carDAO.updateCar(car);
    }

    public void deleteCarById(long id) {
        carDAO.deleteCarById(id);
    }

    public Car findCarById(long id) {
        return carDAO.findCarById(id);
    }

    public Car findCarByPrice(double price) {
        return carDAO.findCarByPrice(price);
    }

    public Car findCarByStockQuantity(int stock_quantity) {
        return carDAO.findCarByStockQuantity(stock_quantity);
    }

    public List<Car> findCarByBrandAndModel(String brand, String model) {
        return carDAO.findCarByBrandAndModel(brand, model);
    }


}

package com.Product_management_appli.ProductManagementAppli.Controller;

import com.Product_management_appli.ProductManagementAppli.dtos.CarRequestDTO;
import com.Product_management_appli.ProductManagementAppli.entity.Car;
import com.Product_management_appli.ProductManagementAppli.mappers.CarMapper;
import com.Product_management_appli.ProductManagementAppli.services.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<List<CarRequestDTO>> findAllCar() {
        List<Car> cars = carService.findAllCar();

        List<CarRequestDTO> carDTOs = cars.stream()
                .map(CarMapper::CarToCarDto)
                .toList();
        return ResponseEntity.ok(carDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarRequestDTO> findCarById(@PathVariable long id) {
        Car car = carService.findCarById(id);  // Service appelle DAO
        CarRequestDTO carDTO = CarMapper.CarToCarDto(car);
        return ResponseEntity.ok(carDTO);
    }

    @GetMapping("brand/{brand}")
    public ResponseEntity<List<CarRequestDTO>> findCarByBrand(@PathVariable String brand) {
        return ResponseEntity.ok(carService.findCarByBrand(brand));
    }

    @GetMapping("model/{model}")
    public ResponseEntity<List<CarRequestDTO>> findCarByModel(@PathVariable String model) {
        // TODO: J ai fait comme ça mais apres commit il faut refacto et metre le dans un service66

        return ResponseEntity.ok(carService.findCarByModel(model));
    }

    @PostMapping
    public ResponseEntity<CarRequestDTO> saveCar(@RequestBody CarRequestDTO car) {

        return ResponseEntity.ok(carService.saveCar(car));

    }

    @PutMapping
    public ResponseEntity<CarRequestDTO> updateCar(@RequestBody CarRequestDTO carDTO) {
        Car cars = CarMapper.CarDtoToCar(carDTO);
        Car car = carService.updateCar(cars);
        CarRequestDTO carDTO1 = CarMapper.CarToCarDto(car);
        return ResponseEntity.ok(carDTO1);
    }

    @DeleteMapping("{id}")
    public void deleteCarById(@PathVariable long id) {
        carService.deleteCarById(id);
    }


}

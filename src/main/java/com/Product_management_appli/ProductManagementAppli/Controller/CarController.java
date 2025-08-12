package com.Product_management_appli.ProductManagementAppli.Controller;

import com.Product_management_appli.ProductManagementAppli.DAOorRepository.CarDAO;
import com.Product_management_appli.ProductManagementAppli.dtos.CarRequestDTO;
import com.Product_management_appli.ProductManagementAppli.entity.Car;
import com.Product_management_appli.ProductManagementAppli.mappers.CarMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    private final CarDAO carDAO;
    public CarController(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @GetMapping
    public ResponseEntity<List<CarRequestDTO>> findAllCar(){
        List<Car> cars = carDAO.findAllCar(); // ici ça renvoie List<Car>

        List<CarRequestDTO> carDTOs = cars.stream()
                .map(CarMapper::CarToCarDto) // mappe chaque Car en CarRequestDTO
                .toList();
        return ResponseEntity.ok(carDTOs);
    }

    @GetMapping("/{id}")
    public Car findCarById(@PathVariable long id){
        return carDAO.findCarById(id);
    }
    @GetMapping("brand/{brand}")
    public ResponseEntity<List<CarRequestDTO>> findCarByBrand(@PathVariable  String brand){
        List<Car> cars = carDAO.findCarByBrand(brand);
        List<CarRequestDTO> carDTOs = cars.stream()
                .map(CarMapper::CarToCarDto)
                .toList();
        return ResponseEntity.ok(carDTOs);
    }
    @GetMapping("model/{model}")
    public ResponseEntity<List<CarRequestDTO>> findCarByModel(@PathVariable String model){
        List<Car> cars = carDAO.findCarByModel(model);
        List<CarRequestDTO> carDTOs = cars.stream()
                .map(CarMapper::CarToCarDto)
                .toList();
        return ResponseEntity.ok(carDTOs);
    }
    @PostMapping
    public Car saveCar(Car car){
        return carDAO.saveCar(car);
    }
    @PutMapping
    public Car updateCar(Car car){
        return carDAO.updateCar(car);
    }
    @DeleteMapping("{id}")
    public void deleteCarById(@PathVariable long id){
        carDAO.deleteCarById(id);
    }




}

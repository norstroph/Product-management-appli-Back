package com.Product_management_appli.ProductManagementAppli.Controller;

import com.Product_management_appli.ProductManagementAppli.DAOorRepository.CarDAO;
import com.Product_management_appli.ProductManagementAppli.entity.Car;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarController {
    private final CarDAO carDAO;
    public CarController(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @RequestMapping("/findAll")
    public Car findAllCar(){
        return carDAO.findAllCar();
    }



}

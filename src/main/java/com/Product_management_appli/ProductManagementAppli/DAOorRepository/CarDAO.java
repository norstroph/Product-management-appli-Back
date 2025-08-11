package com.Product_management_appli.ProductManagementAppli.DAOorRepository;

import com.Product_management_appli.ProductManagementAppli.dtos.CarRequestDTO;
import com.Product_management_appli.ProductManagementAppli.entity.Car;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDAO {
    private final JdbcTemplate jdbcTemplate;
    public CarDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    RowMapper<Car> carRowMapper = (rs, rowNum) -> new Car(
    rs.getLong("id"),
            rs.getString("brand"),
            rs.getString("model"),
            rs.getDouble("price"),
            rs.getInt("stock_quantity")
    );
    public List<Car> findAllCar(){
        return jdbcTemplate.query("SELECT * FROM car", carRowMapper);
    }

    public Car findCarById(long id){
        return jdbcTemplate.queryForObject("SELECT * FROM car WHERE id = ?", carRowMapper, id);
    }
    public Car findCarByBrandAndModel(String brand, String model){
        return jdbcTemplate.queryForObject("SELECT * FROM car WHERE brand = ? AND model = ?", carRowMapper, brand, model);
    }
    public Car findCarByModel(String model){
        return jdbcTemplate.queryForObject("SELECT * FROM car WHERE model = ?", carRowMapper, model);
    }
    public Car findCarByBrand(String brand){
        return jdbcTemplate.queryForObject("SELECT * FROM car WHERE brand = ?", carRowMapper, brand);
    }
    public Car findCarByPrice(double price){
        return jdbcTemplate.queryForObject("SELECT * FROM car WHERE price = ?", carRowMapper, price);
    }
    public Car findCarByStockQuantity(int stock_quantity){
        return jdbcTemplate.queryForObject("SELECT * FROM car WHERE stock_quantity = ?", carRowMapper, stock_quantity);
    }
    public Car saveCar(Car car){
        jdbcTemplate.update("INSERT INTO car (brand, model, price, stock_quantity) VALUES (?, ?, ?, ?)", car.getBrand(), car.getModel(), car.getPrice(), car.getStock_quantity());
        return car;
    }
    public Car updateCar(Car car){
        jdbcTemplate.update("UPDATE car SET brand = ?, model = ?, price = ?, stock_quantity = ? WHERE id = ?", car.getBrand(), car.getModel(), car.getPrice(), car.getStock_quantity(), car.getId());
        return car;
    }
    public void deleteCarById(long id){
        jdbcTemplate.update("DELETE FROM car WHERE id = ?", id);
    }


}

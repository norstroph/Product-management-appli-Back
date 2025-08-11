package com.Product_management_appli.ProductManagementAppli.DAOorRepository;

import com.Product_management_appli.ProductManagementAppli.entity.Car;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

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
    public Car findAllCar(){
        return jdbcTemplate.queryForObject("SELECT * FROM car", carRowMapper);
    }

    public Car getCarById(long id){
        return jdbcTemplate.queryForObject("SELECT * FROM car WHERE id = ?", carRowMapper, id);
    }
    public Car getCarByBrandAndModel(String brand, String model){
        return jdbcTemplate.queryForObject("SELECT * FROM car WHERE brand = ? AND model = ?", carRowMapper, brand, model);
    }
    public Car getCarByModel(String model){
        return jdbcTemplate.queryForObject("SELECT * FROM car WHERE model = ?", carRowMapper, model);
    }
    public Car getCarByBrand(String brand){
        return jdbcTemplate.queryForObject("SELECT * FROM car WHERE brand = ?", carRowMapper, brand);
    }
    public Car getCarByPrice(double price){
        return jdbcTemplate.queryForObject("SELECT * FROM car WHERE price = ?", carRowMapper, price);
    }
    public Car getCarByStockQuantity(int stock_quantity){
        return jdbcTemplate.queryForObject("SELECT * FROM car WHERE stock_quantity = ?", carRowMapper, stock_quantity);
    }

}

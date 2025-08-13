package com.Product_management_appli.ProductManagementAppli.DAOorRepository;

import com.Product_management_appli.ProductManagementAppli.dtos.CarRequestDTO;
import com.Product_management_appli.ProductManagementAppli.entity.Car;
import com.Product_management_appli.ProductManagementAppli.exception.NotFoundHandlerException;
import com.Product_management_appli.ProductManagementAppli.exception.TechnicalDatabaseException;
import org.springframework.dao.DataAccessException;
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

    public List<Car> findAllCar() {
        try {
            return jdbcTemplate.query("SELECT * FROM car", carRowMapper);

        } catch (Exception e) {
            throw new TechnicalDatabaseException("Erreur lors de la récupération des produits", e);
        }
    }

    public Car findCarById(long id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM car WHERE id = ?", carRowMapper, id);
        } catch (Exception e) {
            throw new NotFoundHandlerException("error car: " + id + " not found");
        }

    }

    public List<Car> findCarByBrandAndModel(String brand, String model) {
        try {
            return jdbcTemplate.query("SELECT * FROM car WHERE brand = ? AND model = ?", carRowMapper, brand, model);
        } catch (Exception e) {
            throw new NotFoundHandlerException("error car: " + brand + " " + model + " not found");
        }
    }

    public List<Car> findCarByModel(String model) {
        try {
            return jdbcTemplate.query("SELECT * FROM car WHERE model = ?", carRowMapper, model);

        } catch (Exception e) {
            throw new NotFoundHandlerException("error car: " + model + " not found");
        }
    }

    public List<Car> findCarByBrand(String brand) {
        try {
            List<Car> cars = jdbcTemplate.query("SELECT * FROM car WHERE brand = ?", carRowMapper, brand);
            if (cars.isEmpty()) {
                throw new NotFoundHandlerException("error car with Brand : " + brand + " not found");
            }
            return cars;

        } catch (DataAccessException e) {
            throw new TechnicalDatabaseException("Error Data base", e);
        }
    }

    public Car findCarByPrice(double price) {
        return jdbcTemplate.queryForObject("SELECT * FROM car WHERE price = ?", carRowMapper, price);
    }

    public Car findCarByStockQuantity(int stock_quantity) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM car WHERE stock_quantity = ?", carRowMapper, stock_quantity);
        } catch (Exception e) {
            throw new NotFoundHandlerException("error car: " + stock_quantity + " not found");
        }
    }

    public Car saveCar(Car car) {
        jdbcTemplate.update("INSERT INTO car (brand, model, price, stock_quantity) VALUES (?, ?, ?, ?)", car.getBrand(), car.getModel(), car.getPrice(), car.getStockQuantity());
        return car;
    }

    public Car updateCar(Car car) {
        if (car.getId() == 0) {
            throw new IllegalArgumentException("L'ID du véhicule doit être renseigné pour une mise à jour.");
        }

        int rowsAffected = jdbcTemplate.update(
                "UPDATE car SET brand = ?, model = ?, price = ?, stock_quantity = ? WHERE id = ?",
                car.getBrand(), car.getModel(), car.getPrice(), car.getStockQuantity(), car.getId()
        );

        if (rowsAffected == 0) {
            throw new NotFoundHandlerException("Voiture avec ID " + car.getId() + " non trouvée.");
        }

        return car;

    }

    public void deleteCarById(long id) {
        jdbcTemplate.update("DELETE FROM car WHERE id = ?", id);
    }


}

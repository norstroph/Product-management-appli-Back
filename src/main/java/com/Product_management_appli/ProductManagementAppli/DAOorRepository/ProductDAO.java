package com.Product_management_appli.ProductManagementAppli.DAOorRepository;

import com.Product_management_appli.ProductManagementAppli.entity.Product;
import com.Product_management_appli.ProductManagementAppli.entity.ProductType;
import com.Product_management_appli.ProductManagementAppli.exception.NotFoundHandlerException;
import com.Product_management_appli.ProductManagementAppli.exception.TechnicalDatabaseException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAO {

    private final JdbcTemplate jdbcTemplate;
    public ProductDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    RowMapper<Product> productRowMapper = (rs, rowNum) -> new Product(
            rs.getLong("id"),
            rs.getString("name"),
            rs.getDouble("price"),
            rs.getInt("stock_quantity"),
            ProductType.valueOf(rs.getString("type"))// valueOf est une methode donner pour le type enum donc la on le transforme juste en String
    );

    public List<Product> findProductById(long id) {
        try {
            return jdbcTemplate.query("SELECT * FROM product WHERE id = ?", productRowMapper, id).stream().toList();
        }catch (Exception e) {
            throw new NotFoundHandlerException("error product: " + id + " not found");
        }
    }
    public List<Product> findAllProduct() {
        try {
            return jdbcTemplate.query("SELECT * FROM product", productRowMapper);
        }catch (DataAccessException e) {
            e.printStackTrace();
            throw new TechnicalDatabaseException("error product not found", e);
        }
    }
    public List<Product> findProductByType(ProductType type) {
        try {
            return jdbcTemplate.query("SELECT * FROM product WHERE type = ?", productRowMapper, type);
        }
        catch (DataAccessException e) {
            throw new TechnicalDatabaseException("error product: " + type + " not found", e);
        }
    }

    //je ne pance pas que se soit utille
    public List<Product> findProductByCarId(long carId) {
        try {
            return jdbcTemplate.query("SELECT * FROM product WHERE car_id = ?", productRowMapper, carId);
        }catch (Exception e) {
            throw new NotFoundHandlerException("error product: " + carId + " not found");
        }
    }
    public List<Product> findProductByName(String name) {
        try {
            return jdbcTemplate.query("SELECT * FROM product WHERE name = ?", productRowMapper, name);
        }
        catch (Exception e) {
            throw new NotFoundHandlerException("error product: " + name + " not found");
        }
    }

    public Product saveProduct(Product product) {
        try {
            jdbcTemplate.update("INSERT INTO product ( name, price, stock_quantity, type) VALUES (?, ?, ?, ?)", product.getName(), product.getPrice(), product.getStockQuantity(), product.getType().name());
            return product;
        } catch (DataAccessException e) {
            throw new TechnicalDatabaseException("error product: " + product.getName() +"not found or SQL error", e);
        }
    }

}

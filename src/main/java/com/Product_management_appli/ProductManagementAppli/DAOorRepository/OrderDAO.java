package com.Product_management_appli.ProductManagementAppli.DAOorRepository;

import com.Product_management_appli.ProductManagementAppli.entity.Order;
import com.Product_management_appli.ProductManagementAppli.exception.TechnicalDatabaseException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDAO {
    private final JdbcTemplate jdbcTemplate;
    public OrderDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    RowMapper<Order> orderRowMapper = (rs, rowNum) -> new Order(
            rs.getLong("id"),
            rs.getDate("order_date").toLocalDate().atStartOfDay(),
            rs.getLong("customer_id")

    );
    public Order findOrderById(long id) {
        try{
            return jdbcTemplate.queryForObject("SELECT * FROM order WHERE id = ?", orderRowMapper, id);

        }catch (Exception e) {
            throw new TechnicalDatabaseException("error order: " + id + " not found or SQL error", e);
        }
    }

    public List<Order> findAllOrder() {
        try {
            return jdbcTemplate.query("SELECT * FROM order", orderRowMapper);

        }catch (Exception e) {
            throw new TechnicalDatabaseException("error order not found or SQL error", e);
        }
    }
    public List<Order> findOrderByCustomerId(long customerId) {
        try{
            return jdbcTemplate.query("SELECT * FROM order WHERE customer_id = ?", orderRowMapper, customerId);

        }catch (Exception e) {
            throw new TechnicalDatabaseException("error order: " + customerId + " not found or SQL error", e);
        }
    }
    public List<Order> findOrderByDate(String date) {
        try {
            return jdbcTemplate.query("SELECT * FROM order WHERE order_date = ?", orderRowMapper, date);

        }catch (Exception e) {
            throw new TechnicalDatabaseException("error order: " + date + " not found or SQL error", e);
        }
    }

    public Order saveOrder(Order order){
        try {
            jdbcTemplate.update("INSERT INTO order ( order_date, customer_id ) VALUES (?, ? )", order.getDate() , order.getCustomerId());
            return order;
        }catch (Exception e) {
            throw  new TechnicalDatabaseException("error order: " + order.getId() + " not found or SQL error", e);
        }
    }
}

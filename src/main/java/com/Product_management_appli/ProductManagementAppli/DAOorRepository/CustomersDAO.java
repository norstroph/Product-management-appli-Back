package com.Product_management_appli.ProductManagementAppli.DAOorRepository;

import com.Product_management_appli.ProductManagementAppli.entity.Customers;
import com.Product_management_appli.ProductManagementAppli.entity.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CustomersDAO {
    private  final JdbcTemplate jdbcTemplate;
    public CustomersDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    RowMapper<Customers> customersRowMapper = (rs, rowNum) -> new Customers(
            rs.getLong("id"),
            rs.getString("email"),
            rs.getString("password")
    );

    public Customers findCustomerById(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM customers WHERE id = ?", customersRowMapper, id);
    }
    public Customers findCustomerByEmail(String email) {
        return jdbcTemplate.queryForObject("SELECT * FROM customers WHERE email = ?", customersRowMapper, email);
    }
    public Customers saveCustomer(Customers customer) {
        jdbcTemplate.update("INSERT INTO customers (email, password) VALUES (?, ?)", customer.getEmail(), customer.getPassword());
        return customer;
    }
    public void deleteCustomerById(long id) {
        jdbcTemplate.update("DELETE FROM customers WHERE id = ?", id);
    }
}

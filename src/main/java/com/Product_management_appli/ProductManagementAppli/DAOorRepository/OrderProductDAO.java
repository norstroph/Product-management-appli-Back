package com.Product_management_appli.ProductManagementAppli.DAOorRepository;

import com.Product_management_appli.ProductManagementAppli.entity.OrderProduct;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderProductDAO {
    private final JdbcTemplate jdbcTemplate;
    public OrderProductDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    RowMapper<OrderProduct> orderProductRowMapper = (rs, rowNum) -> new OrderProduct(
            rs.getLong("id"),
            rs.getLong("order_id"),
            rs.getLong("product_id"),
            rs.getInt("quantity")
    );

    public OrderProduct findOrderProductById(long id) {

        return jdbcTemplate.queryForObject("SELECT * FROM order_product WHERE id = ?", orderProductRowMapper, id);
    }
    public List<OrderProduct> findAllOrderProduct() {
        try {
            return jdbcTemplate.query("SELECT * FROM order_product", orderProductRowMapper);
        }catch (Exception e) {
            throw new RuntimeException("error order product not found or SQL error", e);
        }
    }
    public List<OrderProduct> findOrderProductByOrderId(long orderId) {}
    public OrderProduct saveOrderProduct(OrderProduct orderProduct) {
        try {
            jdbcTemplate.update("INSERT INTO order_product ( order_id, product_id, quantity) VALUES (?, ?, ?)", orderProduct.getOrderId(), orderProduct.getProductId(), orderProduct.getQuantity());
            return orderProduct;
        }catch (Exception e) {
            throw new RuntimeException("error order product: " + orderProduct.getId() + " not found or SQL error", e);
        }

    }
    public void deleteOrderProductById(long id) {
        try {
            jdbcTemplate.update("DELETE FROM order_product WHERE id = ?", id);

        }catch (Exception e) {

            throw new RuntimeException("error order product: " + id + " not found or SQL error", e);
        }
    }
    public void updateOrderProduct(OrderProduct orderProduct) {
        try{
            jdbcTemplate.update("UPDATE order_product SET quantity = ? WHERE id = ?", orderProduct.getQuantity(), orderProduct.getId());
        }catch (Exception e) {
            throw new RuntimeException("error order product: " + orderProduct.getId() + " not found or SQL error", e);
        }
    }

}

package com.Product_management_appli.ProductManagementAppli.services;

import com.Product_management_appli.ProductManagementAppli.DAOorRepository.OrderDAO;
import com.Product_management_appli.ProductManagementAppli.entity.Car;
import com.Product_management_appli.ProductManagementAppli.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private static OrderDAO orderDAO;
    public OrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }
    public List<Order> findAllOrder() {
        List<Order> order = orderDAO.findAllOrder();
        return order;
    }
    public Order saveOrder(Order order){
        return orderDAO.saveOrder(order);
    }

}

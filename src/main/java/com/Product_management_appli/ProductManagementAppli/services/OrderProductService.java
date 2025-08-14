package com.Product_management_appli.ProductManagementAppli.services;

import com.Product_management_appli.ProductManagementAppli.DAOorRepository.OrderProductDAO;
import com.Product_management_appli.ProductManagementAppli.entity.OrderProduct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderProductService {
    private static OrderProductDAO orderProductDAO;
    public OrderProductService(OrderProductDAO orderProductDAO) {
        this.orderProductDAO = orderProductDAO;
    }
    public List<OrderProduct> findAll(){
        return orderProductDAO.findAllOrderProduct();
    }

    public OrderProduct saveOrderProduct(OrderProduct orderProduct){
        return orderProductDAO.saveOrderProduct(orderProduct);
    }
    public void deleteOrderProductById(long id){
        orderProductDAO.deleteOrderProductById(id);
    }
    public void updateOrderProduct(OrderProduct orderProduct){
        orderProductDAO.updateOrderProduct(orderProduct);
    }
}

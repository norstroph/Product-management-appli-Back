package com.Product_management_appli.ProductManagementAppli.mappers;

import com.Product_management_appli.ProductManagementAppli.dtos.OrderResponseDTO;
import com.Product_management_appli.ProductManagementAppli.entity.Order;

import java.util.List;

public class OrderMapper {
    public static OrderResponseDTO OrderToOrderResponseDTO( Order listOrder){
        OrderResponseDTO finalListOrder = new OrderResponseDTO() ;
        finalListOrder.setDate(listOrder.getDate());
        finalListOrder.setCustomerId(listOrder.getCustomerId());
        return finalListOrder;
    }

    public static Order ResponseDTOToOrder( OrderResponseDTO order){
        Order newOrder = new Order();
        newOrder.setDate(order.getDate());
        newOrder.setCustomerId(order.getCustomerId());
        return newOrder;

    }
}

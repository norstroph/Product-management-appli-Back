package com.Product_management_appli.ProductManagementAppli.Controller;

import com.Product_management_appli.ProductManagementAppli.dtos.OrderRequestDTO;
import com.Product_management_appli.ProductManagementAppli.dtos.OrderResponseDTO;
import com.Product_management_appli.ProductManagementAppli.entity.Order;
import com.Product_management_appli.ProductManagementAppli.mappers.OrderMapper;
import com.Product_management_appli.ProductManagementAppli.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private static OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> findAllOrder(){
        List<Order> listOrder = orderService.findAllOrder();
        List<OrderResponseDTO> finalListOrder = listOrder.stream().map(OrderMapper::OrderToOrderResponseDTO).toList();
        return ResponseEntity.ok(finalListOrder);

    }
    @PostMapping
    public ResponseEntity<OrderResponseDTO> saveOrder(@RequestBody OrderResponseDTO order){
        Order clientOrder = OrderMapper.ResponseDTOToOrder(order);
        Order newOrder = orderService.saveOrder(clientOrder);
        OrderResponseDTO orderResponseDTO = OrderMapper.OrderToOrderResponseDTO(newOrder);
        return ResponseEntity.ok(orderResponseDTO);
    }
}

package com.Product_management_appli.ProductManagementAppli.Controller;

import com.Product_management_appli.ProductManagementAppli.entity.Order;
import com.Product_management_appli.ProductManagementAppli.entity.OrderProduct;
import com.Product_management_appli.ProductManagementAppli.services.OrderProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderproduct")
public class OrderProductController {
    private final OrderProductService orderProductService;

    public OrderProductController(OrderProductService orderProductService) {
        this.orderProductService = orderProductService;
    }

    @GetMapping()
    public ResponseEntity<List<OrderProduct>> findAllOrderProduct(){
        List<OrderProduct> orderProduct = orderProductService.findAll();
        return ResponseEntity.ok(orderProduct);
    }

    @PostMapping
    public ResponseEntity<OrderProduct> saveOrderProduct(OrderProduct orderProduct){
        OrderProduct newOrderProduct = orderProductService.saveOrderProduct(orderProduct);
        return ResponseEntity.ok(newOrderProduct);
    }
    @PutMapping
    public ResponseEntity<OrderProduct> updateOrderProduct(OrderProduct orderProduct){
        orderProductService.updateOrderProduct(orderProduct);
        return ResponseEntity.ok(orderProduct);
    }
    @DeleteMapping("{id}")
    public void deleteOrderProductById(@PathVariable long id){
        orderProductService.deleteOrderProductById(id);
    }



}

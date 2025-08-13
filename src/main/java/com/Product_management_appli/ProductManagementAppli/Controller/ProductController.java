package com.Product_management_appli.ProductManagementAppli.Controller;



import com.Product_management_appli.ProductManagementAppli.dtos.ProductResponseDTO;
import com.Product_management_appli.ProductManagementAppli.entity.Product;
import com.Product_management_appli.ProductManagementAppli.mappers.CarMapper;
import com.Product_management_appli.ProductManagementAppli.mappers.ProductMapper;
import com.Product_management_appli.ProductManagementAppli.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> findAllProduct(){
            List<Product> product = productService.findAllProduct();
        List<ProductResponseDTO> productDTOs = product.stream()
                .map(ProductMapper::productToProductResponseDTO)
                .toList();

        return ResponseEntity.ok(productDTOs);
    }
}

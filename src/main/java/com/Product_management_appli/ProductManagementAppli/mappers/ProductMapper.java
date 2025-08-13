package com.Product_management_appli.ProductManagementAppli.mappers;

import com.Product_management_appli.ProductManagementAppli.dtos.ProductResponseDTO;
import com.Product_management_appli.ProductManagementAppli.entity.Product;

public class ProductMapper {
    public static ProductResponseDTO productToProductResponseDTO(Product product){
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setName(product.getName());
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setStock_quantity(product.getStock_quantity());
        return productResponseDTO;
    }
}

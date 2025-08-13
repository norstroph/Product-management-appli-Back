package com.Product_management_appli.ProductManagementAppli.mappers;

import com.Product_management_appli.ProductManagementAppli.dtos.ProductRequestDTO;
import com.Product_management_appli.ProductManagementAppli.dtos.ProductResponseDTO;
import com.Product_management_appli.ProductManagementAppli.entity.Product;

public class ProductMapper {
    public static ProductResponseDTO productToProductResponseDTO(Product product){
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setName(product.getName());
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setStockQuantity(product.getStockQuantity());
        return productResponseDTO;
    }
    public static Product productRequestDTOToProduct(ProductRequestDTO productRequest){
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setStockQuantity(productRequest.getStockQuantity());
        product.setType(productRequest.getType());
        return product ;

    }
}

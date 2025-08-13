package com.Product_management_appli.ProductManagementAppli.services;

import com.Product_management_appli.ProductManagementAppli.DAOorRepository.ProductDAO;
import com.Product_management_appli.ProductManagementAppli.dtos.ProductRequestDTO;
import com.Product_management_appli.ProductManagementAppli.dtos.ProductResponseDTO;
import com.Product_management_appli.ProductManagementAppli.entity.Product;
import com.Product_management_appli.ProductManagementAppli.exception.NotFoundHandlerException;
import com.Product_management_appli.ProductManagementAppli.mappers.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductDAO productDAO;
    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public List<Product> findAllProduct(){
        List<Product> product = productDAO.findAllProduct();
        if(product.isEmpty()){
            throw new NotFoundHandlerException("no product found size = 0");
        }
        return product ;
    }
    public Product saveProduct(Product product){
        try{
            Product newProduct = productDAO.saveProduct(product);
            return newProduct ;
        } catch (Exception e){
            throw new NotFoundHandlerException("error product: " + product.getName() + " not found");
        }
    }
}

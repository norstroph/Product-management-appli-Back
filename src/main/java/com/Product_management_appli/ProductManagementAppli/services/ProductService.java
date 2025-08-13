package com.Product_management_appli.ProductManagementAppli.services;

import com.Product_management_appli.ProductManagementAppli.DAOorRepository.ProductDAO;
import com.Product_management_appli.ProductManagementAppli.entity.Product;
import com.Product_management_appli.ProductManagementAppli.exception.NotFoundHandlerException;
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
            throw new NotFoundHandlerException("no product found");
        }
        return product ;
    }
}

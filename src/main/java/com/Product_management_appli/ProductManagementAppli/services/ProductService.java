package com.Product_management_appli.ProductManagementAppli.services;

import com.Product_management_appli.ProductManagementAppli.DAOorRepository.CarDAO;
import com.Product_management_appli.ProductManagementAppli.DAOorRepository.ProductDAO;
import com.Product_management_appli.ProductManagementAppli.dtos.ProductRequestDTO;
import com.Product_management_appli.ProductManagementAppli.dtos.ProductResponseDTO;
import com.Product_management_appli.ProductManagementAppli.entity.Car;
import com.Product_management_appli.ProductManagementAppli.entity.Product;
import com.Product_management_appli.ProductManagementAppli.entity.ProductType;
import com.Product_management_appli.ProductManagementAppli.exception.NotFoundHandlerException;
import com.Product_management_appli.ProductManagementAppli.exception.TechnicalDatabaseException;
import com.Product_management_appli.ProductManagementAppli.mappers.ProductMapper;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductDAO productDAO;
    private final CarDAO carDAO;

    public ProductService(ProductDAO productDAO, CarDAO carDAO) {
        this.productDAO = productDAO;
        this.carDAO = carDAO;
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

    public ProductResponseDTO productToProductResponseDTO(Product product){
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setName(product.getName());
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setStockQuantity(product.getStockQuantity());
        return productResponseDTO;
    }
    public List<ProductResponseDTO> listOfProductToProductResponseDTO(List<Product> products){
        List<ProductResponseDTO> productResponseDTOS = new ArrayList<>();
        for(Product product : products){
            productResponseDTOS.add(productToProductResponseDTO(product));
        }
        return productResponseDTOS;
    }

    @Transactional(noRollbackFor = { DuplicateKeyException.class, TechnicalDatabaseException.class })
    public List<Product> saveProductsWithId(List<ProductRequestDTO> products ){
        List<Product> listProduct =  new ArrayList<>();
        // faire une condition si il et pas vide alors
        if(products != null) {
            // si il est pas vide il faut passer sur chaque element
            for (ProductRequestDTO product : products) {
                //recuperer l id verifier s'il et bien dans car alors mapper car avec product
                   Car car = carDAO.findCarById(product.getId());

                if (car != null) {
                    Product newProduct = new Product(
                            null,
                            car.getBrand() + " " + car.getModel(),
                            car.getPrice(),
                            car.getStockQuantity(),
                            ProductType.CAR
                    );

                    try {
                        Product saved = productDAO.saveProduct(newProduct);
                        listProduct.add(saved);
                    } catch (DuplicateKeyException e) {
                        System.out.println("Produit déjà existant : " + newProduct.getName()) ;
                    }
                }

            }

        }
        return listProduct;
        //
    }



}

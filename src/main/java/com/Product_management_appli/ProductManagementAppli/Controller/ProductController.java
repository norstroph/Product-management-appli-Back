package com.Product_management_appli.ProductManagementAppli.Controller;



import com.Product_management_appli.ProductManagementAppli.dtos.ProductRequestDTO;
import com.Product_management_appli.ProductManagementAppli.dtos.ProductResponseDTO;
import com.Product_management_appli.ProductManagementAppli.entity.Product;
import com.Product_management_appli.ProductManagementAppli.mappers.ProductMapper;
import com.Product_management_appli.ProductManagementAppli.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping
    public ResponseEntity<ProductResponseDTO> saveProducts(@RequestBody ProductRequestDTO product){
        Product products = ProductMapper.productRequestDTOToProduct(product);
        Product newProduct = productService.saveProduct(products);
        ProductResponseDTO productResponseDTO = ProductMapper.productToProductResponseDTO(newProduct);
    return ResponseEntity.ok(productResponseDTO);
    }
    @PostMapping("/savewithid")
    public ResponseEntity<List<ProductResponseDTO>> saveProductsWithId(@RequestBody List<ProductRequestDTO> product){
        List<Product> listProduct = productService.saveProductsWithId(product);
        List<ProductResponseDTO> productResponseDTOS = productService.listOfProductToProductResponseDTO(listProduct);
        return ResponseEntity.ok(productResponseDTOS);
    }


}

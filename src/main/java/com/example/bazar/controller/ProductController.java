package com.example.bazar.controller;

import com.example.bazar.model.Product;
import com.example.bazar.model.Sale;
import com.example.bazar.service.IProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    
    @Autowired
    private IProductService productInter;
    
    @PostMapping("/products/create")
    public ResponseEntity<String> createProduct(@RequestBody Product product){
        productInter.createProduct(product);
        return new ResponseEntity<>("Product created succesfully!", HttpStatus.CREATED);
    }
    
    @GetMapping("/products")
    public List<Product> getAll(){
        return productInter.getAll();
    }
    
    @GetMapping("/products/{product_code}")
    public Product getProductById(@PathVariable Long product_code){
        return productInter.getProductById(product_code);
    }
    
    @DeleteMapping("/products/delete/{product_code}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long product_code){
        productInter.deleteProduct(product_code);
        return new ResponseEntity<>("Product deleted succesfully", HttpStatus.OK);
    }
    
    @PutMapping("/products/edit/{product_code}")
    public Product editProduct(@PathVariable Long product_code,
            @RequestParam(required = true, name = "id") Long newCode,
            @RequestParam(required = false, name = "name") String productName,
            @RequestParam(required = false, name = "brand") String brand,
            @RequestParam(required = false, name = "cost") double cost,
            @RequestParam(required = false, name = "stock") double stock,
            @RequestParam(required = false, name = "sale") Sale sale){
        productInter.editProduct(product_code, newCode, productName,
                brand, cost, stock, sale);
        return productInter.getProductById(newCode);
    }
    
    @GetMapping("/products/missing_stock")
    public List<Product> missingStockProducts(){
        return productInter.missingStockProducts();
    }
}

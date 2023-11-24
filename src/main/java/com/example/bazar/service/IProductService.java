package com.example.bazar.service;

import com.example.bazar.model.Product;
import com.example.bazar.model.Sale;
import java.util.List;

public interface IProductService {

    public void createProduct(Product product);

    public List<Product> getAll();

    public Product getProductById(Long product_code);

    public void deleteProduct(Long product_code);

    public void editProduct(Long product_code, Long newCode, String productName, String brand, double cost, double stock, Sale sale);

    public List<Product> missingStockProducts();
    
}

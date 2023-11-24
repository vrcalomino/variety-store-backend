package com.example.bazar.service;

import com.example.bazar.model.Product;
import com.example.bazar.model.Sale;
import com.example.bazar.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    
    @Autowired
    private ProductRepository productRepo;

    @Override
    public void createProduct(Product product) {
        productRepo.save(product);
    }

    @Override
    public List<Product> getAll() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(Long product_code) {
        return productRepo.findById(product_code).get();
    }

    @Override
    public void deleteProduct(Long product_code) {
        productRepo.deleteById(product_code);
    }

    @Override
    public void editProduct(Long product_code, Long newCode, String productName, String brand, double cost, double stock, Sale sale) {
        Product product = new Product(newCode, productName, brand, cost, stock, sale);
        productRepo.save(product);
    }

    @Override
    public List<Product> missingStockProducts() {
        List<Product> allProducts = productRepo.findAll();
        List<Product> missingStock = new ArrayList<>();
        for(Product aux: allProducts){
            if(aux.getStock() < 5){
                missingStock.add(aux);
            }
        }
        return missingStock;
    }
}

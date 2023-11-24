package com.example.bazar.controller;

import com.example.bazar.dto.CliProSaleDTO;
import com.example.bazar.model.Client;
import com.example.bazar.model.Product;
import com.example.bazar.model.Sale;
import com.example.bazar.service.ISaleService;
import java.time.LocalDate;
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
public class SaleController {
    
    @Autowired
    private ISaleService saleInter;
    
    @PostMapping("/sales/create")
    public ResponseEntity<String> createSale(@RequestBody Sale sale){
        saleInter.createSale(sale);
        return new ResponseEntity<>("Sale created succesfully!", HttpStatus.CREATED);
    }
    
    @GetMapping("/sales")
    public List<Sale> getAll(){
        return saleInter.getAll();
    }
    
    @GetMapping("/sales/{sale_code}")
    public Sale getSaleById(@PathVariable Long sale_code){
        return saleInter.getSaleById(sale_code);
    }
    
    @DeleteMapping("/sales/delete/{sale_code}")
    public ResponseEntity<String> deleteSale(@PathVariable Long sale_code){
        saleInter.deleteSale(sale_code);
        return new ResponseEntity<>("Sale deleted succesfully", HttpStatus.OK);
    }
    
    @PutMapping("/sales/edit/{sale_code}")
    public Sale editSale(@PathVariable Long sale_code,
            @RequestParam(required = true, name = "id") Long newCode,
            @RequestParam(required = false, name = "date") LocalDate sale_date,
            @RequestParam(required = false, name = "total") double total,
            @RequestParam(required = false, name = "products") List<Product> products,
            @RequestParam(required = false, name = "client") Client client){
        saleInter.editClient(newCode, sale_date,
                total, products, client);
        return saleInter.getSaleById(newCode);
    }
    
    @GetMapping("/sales/products/{sale_code}")
    public List<Product> getSaleProducts(@PathVariable Long sale_code){
        return saleInter.getSaleProducts(sale_code);
    }
    
    @GetMapping("/sales/{sale_date}")
    public List<Integer> totalSalesAndTotalRevenue(@PathVariable LocalDate sale_date){
        /*
            This method returns an arraylist in which index 0 is the amount of
            sales made in this date and index 1 is the total of the money made
            by those sales.
        */
        return saleInter.totalSalesAndTotalRevenue(sale_date);
    }
    
    @GetMapping("/sales/biggest_sale")
    public CliProSaleDTO getBiggestSale(){
        return saleInter.getBiggestSale();
    }
}

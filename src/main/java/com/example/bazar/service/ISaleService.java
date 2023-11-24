package com.example.bazar.service;

import com.example.bazar.dto.CliProSaleDTO;
import com.example.bazar.model.Client;
import com.example.bazar.model.Product;
import com.example.bazar.model.Sale;
import java.time.LocalDate;
import java.util.List;

public interface ISaleService {

    public void createSale(Sale sale);

    public Sale getSaleById(Long sale_code);

    public void deleteSale(Long sale_code);

    public List<Sale> getAll();

    public void editClient(Long newCode, LocalDate sale_date, double total, List<Product> products, Client client);

    public List<Product> getSaleProducts(Long sale_code);

    public List<Integer> totalSalesAndTotalRevenue(LocalDate sale_date);

    public CliProSaleDTO getBiggestSale();
    
}

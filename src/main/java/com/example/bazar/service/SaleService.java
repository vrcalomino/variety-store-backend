package com.example.bazar.service;

import com.example.bazar.dto.CliProSaleDTO;
import com.example.bazar.model.Client;
import com.example.bazar.model.Product;
import com.example.bazar.model.Sale;
import com.example.bazar.repository.SaleRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService implements ISaleService {
    
    @Autowired
    private SaleRepository saleRepo;

    @Override
    public void createSale(Sale sale) {
        saleRepo.save(sale);
    }

    @Override
    public Sale getSaleById(Long sale_code) {
        return saleRepo.findById(sale_code).get();
    }

    @Override
    public void deleteSale(Long sale_code) {
        saleRepo.deleteById(sale_code);
    }

    @Override
    public List<Sale> getAll() {
        return saleRepo.findAll();
    }

    @Override
    public void editClient(Long newCode, LocalDate sale_date, double total, List<Product> products, Client client) {
        Sale newSale = new Sale(newCode, sale_date, total, products, client);
        saleRepo.save(newSale);
    }

    @Override
    public List<Product> getSaleProducts(Long sale_code) {
        Sale sale = saleRepo.findById(sale_code).get();
        return sale.getProductsList();
    }

    @Override
    public List<Integer> totalSalesAndTotalRevenue(LocalDate sale_date) {
        List<Sale> sales = getAll();
        List<Integer> salesAndRevenue = new ArrayList<>();
        int total = 0;
        int salesCount = 0;
        for(Sale aux: sales){
            if(aux.getSale_date().equals(sale_date)){
                total += aux.getTotal();
                salesCount += 1;
            }
        }
        salesAndRevenue.add(total);
        salesAndRevenue.add(salesCount);
        return salesAndRevenue;
    }

    @Override
    public CliProSaleDTO getBiggestSale() {
        List<Sale> sales = getAll();
        Sale bestSale = null;
        for(Sale aux: sales){
            if(bestSale == null){
                bestSale = aux;
            } else if(aux.getTotal() < bestSale.getTotal()){
                bestSale = aux;
            }
        }
        
        CliProSaleDTO bestSaleObject = new CliProSaleDTO();
        bestSaleObject.setTotal(bestSale.getTotal());
        bestSaleObject.setSale_code(bestSale.getSale_code());
        bestSaleObject.setClientName(bestSale.getClient().getName());
        bestSaleObject.setClientName(bestSale.getClient().getSurname());
        bestSaleObject.setProductCount(bestSale.getProductsList().size());
        return bestSaleObject;
    }
}

package com.example.bazar.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class CliProSaleDTO implements Serializable {
    
    private Long sale_code;
    private double total;
    private int productCount;
    private String clientName;
    private String clientSurname;
    
}

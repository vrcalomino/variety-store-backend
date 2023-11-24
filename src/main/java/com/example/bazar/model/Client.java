package com.example.bazar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long client_id;
    private String name;
    private String surname;
    private String dni;

    public Client() {
    }

    public Client(Long client_id, String name, String surname, String dni) {
        this.client_id = client_id;
        this.name = name;
        this.surname = surname;
        this.dni = dni;
    }
    
}

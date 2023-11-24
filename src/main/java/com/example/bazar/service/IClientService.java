package com.example.bazar.service;

import com.example.bazar.model.Client;
import java.util.List;

public interface IClientService {

    public void createClient(Client client);

    public List<Client> getAll();

    public Client getClientById(Long client_code);

    public void deleteClient(Long client_code);

    public void editClient(Long newCode, String name, String surname, String dni);
    
}

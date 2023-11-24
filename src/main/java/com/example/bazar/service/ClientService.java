package com.example.bazar.service;

import com.example.bazar.model.Client;
import com.example.bazar.repository.ClientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements IClientService {
    
    @Autowired
    private ClientRepository clientRepo;

    @Override
    public void createClient(Client client) {
        clientRepo.save(client);
    }

    @Override
    public List<Client> getAll() {
        return clientRepo.findAll();
    }

    @Override
    public Client getClientById(Long client_code) {
        return clientRepo.findById(client_code).get();
    }

    @Override
    public void deleteClient(Long client_code) {
        clientRepo.deleteById(client_code);
    }

    @Override
    public void editClient(Long newCode, String name, String surname, String dni) {
        Client client = new Client();
        client.setClient_id(newCode);
        client.setDni(dni);
        client.setName(name);
        client.setSurname(surname);
        clientRepo.save(client);
    }
}

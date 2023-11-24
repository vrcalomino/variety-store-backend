package com.example.bazar.controller;

import com.example.bazar.model.Client;
import com.example.bazar.service.IClientService;
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
public class ClientController {
    
        
    @Autowired
    private IClientService clientInter;
    
    @PostMapping("/clients/create")
    public ResponseEntity<String> createClient(@RequestBody Client client){
        clientInter.createClient(client);
        return new ResponseEntity<>("Client created succesfully!", HttpStatus.CREATED);
    }
    
    @GetMapping("/clients")
    public List<Client> getAll(){
        return clientInter.getAll();
    }
    
    @GetMapping("/clients/{client_code}")
    public Client getClientById(@PathVariable Long client_code){
        return clientInter.getClientById(client_code);
    }
    
    @DeleteMapping("/clients/delete/{client_code}")
    public ResponseEntity<String> deleteClient(@PathVariable Long client_code){
        clientInter.deleteClient(client_code);
        return new ResponseEntity<>("Client deleted succesfully", HttpStatus.OK);
    }
    
    @PutMapping("/clients/edit/{client_code}")
    public Client editClient(@PathVariable Long client_code,
            @RequestParam(required = true, name = "id") Long newCode,
            @RequestParam(required = false, name = "name") String name,
            @RequestParam(required = false, name = "surname") String surname,
            @RequestParam(required = false, name = "dni") String dni){
        clientInter.editClient(newCode, name,
                surname, dni);
        return clientInter.getClientById(newCode);
    }
}

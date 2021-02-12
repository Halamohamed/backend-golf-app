package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.ClientRegister;
import com.bezkoder.springjwt.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {


    @Autowired
    private ClientRepository repository;

    @GetMapping
    public List<ClientRegister> getClients(){
        return repository.findAll();
    }
    @GetMapping("/{id}")
    public ClientRegister getOneClient(@PathVariable String id){
        return repository.findById(id).get();
    }
    @GetMapping("/{name}")
    public ClientRegister getClientByName(@PathVariable String name){
        return repository.findByFirstName(name).get();
    }

    @PostMapping
    public void saveClient(ClientRegister client){
        repository.save(client);
    }

    @PutMapping
    public boolean updateClient(String id){
        if(!repository.existsById(id)){
            return false;
        }
        ClientRegister client = repository.findById(id).get();
        repository.save(client);
        return true;
    }

}

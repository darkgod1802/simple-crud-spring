package com.coderhouse.desafio.controller;

import com.coderhouse.desafio.dao.ClientDAO;
import com.coderhouse.desafio.entity.Client;
import com.coderhouse.desafio.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/clients/{id}")
    public ResponseEntity<?> getClientById(@PathVariable (name = "id") Long id){
        Optional<ClientDAO> client = clientService.getClientById(id);
        if(client.isPresent()){
            return ResponseEntity.ok().body(client.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/clients")
    public ResponseEntity<?> getClients(){
        List<Client> clients = clientService.getAllClients();
        return ResponseEntity.ok().body(clients);
    }

    @PostMapping(value = "/clients")
    public ResponseEntity<?> saveClient(@RequestBody Client client){
        try {
            Client savedClient = clientService.createClient(client);
            return ResponseEntity.created(URI.create("/client/"+client.getId())).body(savedClient);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(null);
        }
    }


}

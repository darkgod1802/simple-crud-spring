package com.coderhouse.desafio.service;

import com.coderhouse.desafio.dao.ClientDAO;
import com.coderhouse.desafio.entity.Client;
import com.coderhouse.desafio.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImp implements ClientService{
    @Autowired
    private ClientRepository clientRepository;

    public Client createClient(Client client){
        return clientRepository.save(client);
    }

    public Optional<ClientDAO> getClientById(Long id){
        Optional<Client> clientOptional = clientRepository.findById(id);
        if(clientOptional.isPresent()){
            Client client = clientOptional.get();
            ClientDAO clientDAO = new ClientDAO(client.getFirstName(), client.getLastName(), client.getAge());
            return Optional.of(clientDAO);
        }
        return Optional.empty();
    }

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }
}

package com.coderhouse.desafio.service;

import com.coderhouse.desafio.dao.ClientDAO;
import com.coderhouse.desafio.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    Client createClient(Client client);
    Optional<ClientDAO> getClientById(Long id);

    List<Client> getAllClients();

}

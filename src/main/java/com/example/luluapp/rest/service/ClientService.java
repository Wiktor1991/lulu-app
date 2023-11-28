package com.example.luluapp.rest.service;

import com.example.luluapp.rest.models.Client;
import com.example.luluapp.rest.repositories.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    public void addClient(Client client){
        this.clientRepository.save(client);

    }
}

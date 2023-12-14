package com.example.luluapp.rest.service;

import com.example.luluapp.rest.models.Client;
import com.example.luluapp.rest.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    public void addClient(Client client){
        this.clientRepository.save(client);

    }

    public List<Client> saveAll(List<Client> clients) {

        return clientRepository.saveAll(clients);
    }
}

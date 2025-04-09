package com.jvl.jvlbank.service.client;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jvl.jvlbank.dto.client.ClientCreateDTO;
import com.jvl.jvlbank.dto.client.ClientResponseDTO;
import com.jvl.jvlbank.model.Client;
import com.jvl.jvlbank.repository.client.ClientRepository;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientResponseDTO create(ClientCreateDTO dto){
        Client client = new Client();
        client.setFullName(dto.getFullName());
        client.setAddress(dto.getAddress());

        Client clientSaved = clientRepository.save(client);

        ClientResponseDTO clientResponse = new ClientResponseDTO();
        clientResponse.setId(clientSaved.getId());
        clientResponse.setFullName(clientSaved.getFullName());
        client.setAddress(clientSaved.getAddress());

        return clientResponse;
    }

    public Optional<Client> findById(Long id){
        return clientRepository.findById(id);
    }

    public void updateAddress(Long id, String newAddress){
        clientRepository.findById(id).ifPresent(client -> {
            client.setAddress(newAddress);
            clientRepository.save(client);
        });
    }
}

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
        clientResponse.setAddress(clientSaved.getAddress());

        return clientResponse;
    }

    public Optional<ClientResponseDTO> findById(Long id){
        return clientRepository.findById(id)
            .map(client -> {
                ClientResponseDTO dto = new ClientResponseDTO();
                dto.setId(client.getId());
                dto.setFullName(client.getFullName());
                dto.setAddress(client.getAddress());
                return dto;
            });
    }

    public void updateAddress(Long id, String newAddress){
        clientRepository.findById(id).ifPresent(client -> {
            client.setAddress(newAddress);
            clientRepository.save(client);
        });
    }

    public Object getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}

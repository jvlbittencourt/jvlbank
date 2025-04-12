package com.jvl.jvlbank.service.client;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jvl.jvlbank.dto.client.ClientCreateDTO;
import com.jvl.jvlbank.dto.client.ClientResponseDTO;
import com.jvl.jvlbank.dto.client.ClientUpdateAddressDTO;
import com.jvl.jvlbank.mapper.ClientMapper;
import com.jvl.jvlbank.model.Client;
import com.jvl.jvlbank.repository.client.ClientRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    // public ClientResponseDTO create(ClientCreateDTO dto){
    //     Client client = new Client();
    //     client.setFullName(dto.getFullName());
    //     client.setAddress(dto.getAddress());
    //     Client clientSaved = clientRepository.save(client);
    //     ClientResponseDTO clientResponse = new ClientResponseDTO();
    //     clientResponse.setId(clientSaved.getId());
    //     clientResponse.setFullName(clientSaved.getFullName());
    //     clientResponse.setAddress(clientSaved.getAddress());
    //     return clientResponse;
    // }

    public ClientResponseDTO create(ClientCreateDTO dto){
        Client client = clientMapper.toModel(dto);
        client = clientRepository.save(client);
        return clientMapper.toDTO(client);
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

    public void updateAddress(Long id, ClientUpdateAddressDTO dto){
        clientRepository.findById(id).ifPresent(client -> {
            client.setAddress(dto.getNewAddress());
            clientRepository.save(client);
        });
    }

    // public List<ClientResponseDTO> getAll() {
    //     List<ClientResponseDTO> list = new ArrayList<>();
    //     clientRepository.findAll().forEach(client->{
    //         ClientResponseDTO dto = new ClientResponseDTO();
    //         dto.setId(client.getId());
    //         dto.setFullName(client.getFullName());
    //         dto.setAddress(client.getAddress());
    //         list.add(dto);
    //     });
    //     return list;
    // }

    public List<ClientResponseDTO> getAll(){
        List<Client> clients = clientRepository.findAll();
        return clientMapper.toDTOList(clients);
    }

    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}

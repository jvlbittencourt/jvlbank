package com.jvl.jvlbank.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.jvl.jvlbank.dto.client.ClientCreateDTO;
import com.jvl.jvlbank.dto.client.ClientResponseDTO;
import com.jvl.jvlbank.model.Client;

    
@Component
public class ClientMapper{

    //Model -> ResponseDTO
    public ClientResponseDTO toDTO(Client client){
        ClientResponseDTO dto = new ClientResponseDTO();
        dto.setId(client.getId());
        dto.setFullName(client.getFullName());
        dto.setAddress(client.getAddress());
        return dto;
    }

    //Create DTO -> Model
    public Client toModel(ClientCreateDTO dto){
        Client client = new Client();
        client.setFullName(dto.getFullName());
        client.setAddress(dto.getAddress());
        return client;
    }

    //List Entity -> List DTO
    public List<ClientResponseDTO> toDTOList(List<Client> clients){
        return clients.stream().map(this::toDTO).collect(Collectors.toList());
    }
    
}    


package com.jvl.jvlbank.controller.client;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jvl.jvlbank.service.client.ClientService;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/clients")
public class ClientController {
    
    private final ClientService clientService;

    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @PatchMapping("/{id}/address")
    public void updateAddress(@PathVariable Long id, @RequestBody String newAddress) {
        clientService.updateAddress(id, newAddress);
    }
}

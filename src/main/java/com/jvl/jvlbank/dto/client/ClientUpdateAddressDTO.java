package com.jvl.jvlbank.dto.client;

import jakarta.validation.constraints.NotBlank;

public class ClientUpdateAddressDTO {
    
    @NotBlank(message = "Address cannot be blank")
    private String newAddress;

    public String getNewAddress(){
        return newAddress;
    }

    public void setNewAddress(String newAddress){
        this.newAddress= newAddress;
    }
}

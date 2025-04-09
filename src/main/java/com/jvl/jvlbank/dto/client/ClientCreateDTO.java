package com.jvl.jvlbank.dto.client;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ClientCreateDTO {

    @NotNull
    private String fullName;

    @NotNull
    private String address;
}

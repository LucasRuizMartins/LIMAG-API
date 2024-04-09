package com.limag.sistema_limag.dto;

import com.limag.sistema_limag.entities.Client;
import jakarta.validation.constraints.NotBlank;

public class ClientDTO {


    private Long id;

    @NotBlank
    private String name;
    private String address;
    private ClientGroupDTO clientGroup;

    public ClientDTO(Long id, String name, String address, ClientGroupDTO clientGroup) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.clientGroup = clientGroup;
    }
    public ClientDTO(Client entity) {
        id = entity.getId();
        name = entity.getName();
        address = entity.getAddress();
        clientGroup = new ClientGroupDTO(entity.getClientGroup());

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public ClientGroupDTO getClientGroup() {
        return clientGroup;
    }
}

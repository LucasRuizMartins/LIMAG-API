package com.limag.sistema_limag.dto;

import com.limag.sistema_limag.entities.Client;
import com.limag.sistema_limag.entities.ClientGroup;

public class ClientGroupDTO {

    private Long id;
    private String name;

    public ClientGroupDTO() {

    }
    public ClientGroupDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ClientGroupDTO(ClientGroup entity) {
        id = entity.getId();
       name = entity.getName();
     }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

package com.limag.sistema_limag.dto;

import com.limag.sistema_limag.entities.Client;
import com.limag.sistema_limag.entities.ClientGroup;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public class ClientGroupDTO {

    private Long id;
    private String name;

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

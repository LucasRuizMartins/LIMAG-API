package com.limag.sistema_limag.dto;

import com.limag.sistema_limag.entities.ClientGroup;
import com.limag.sistema_limag.entities.Purchaser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PurchaserDTO {

    private Long id;
    private String name ;
    private String origin;
    private String phoneNumber;
    private String email;
    private ClientGroup clientGroup;


    public PurchaserDTO(Purchaser entity) {
        id = entity.getId();
        name = entity.getName();
        origin = entity.getOrigin();
        phoneNumber = entity.getPhoneNumber();
        email = entity.getEmail();
        clientGroup = entity.getClientGroup();

    }





}

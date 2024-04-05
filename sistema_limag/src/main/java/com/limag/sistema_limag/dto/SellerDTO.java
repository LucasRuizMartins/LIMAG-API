package com.limag.sistema_limag.dto;
import com.limag.sistema_limag.entities.Seller;
import com.limag.sistema_limag.enums.SellerNivel;

public class SellerDTO {

    private Long id;
    private SellerNivel sellerNivel;
    private String squad;
    public SellerDTO() {

    }
    public SellerDTO(Seller entity) {
        id = entity.getId();
        sellerNivel = entity.getSellerNivel();
        squad = entity.getSquad();

    }


    public Long getId() {
        return id;
    }

    public SellerNivel getSellerNivel() {
        return sellerNivel;
    }

    public String getSquad() {
        return squad;
    }


}

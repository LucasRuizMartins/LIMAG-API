package com.limag.sistema_limag.dto;

import com.limag.sistema_limag.entities.PurchaserForSeller;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PurchaserForSellerDTO {

    private Long id;
    private SellerDTO seller;
    private PurchaserDTO purchaser;
    private Integer pote;
    private LocalDate referenceDate;

    public PurchaserForSellerDTO(PurchaserForSeller entity) {
        id = entity.getId();
        pote = entity.getPote();
        referenceDate = entity.getReferenceDate();

        seller = new SellerDTO(entity.getSeller());
        purchaser = new PurchaserDTO(entity.getPurchaser());

    }

}

package com.limag.sistema_limag.entities;

import com.limag.sistema_limag.dto.EmployeeDTO;
import com.limag.sistema_limag.dto.PurchaserForSellerDTO;
import com.limag.sistema_limag.dto.SellerDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_compradores_por_vendedores")
public class PurchaserForSeller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="seller_id")
    private Seller seller;

    @ManyToOne
    @JoinColumn(name="purchaser_id")
    private Purchaser purchaser;

    private Integer pote;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDate referenceDate;

    public PurchaserForSeller (PurchaserForSellerDTO dto) {
        seller = new Seller(dto.getSeller());
        purchaser = new Purchaser(dto.getPurchaser());
        pote = dto.getPote();
        referenceDate = dto.getReferenceDate();

    }

}

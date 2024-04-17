package com.limag.sistema_limag.entities;



import com.limag.sistema_limag.dto.SellerDTO;
import com.limag.sistema_limag.enums.Department;
import com.limag.sistema_limag.enums.SellerNivel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_vendedores")
public class Seller extends Employee {

    @Enumerated(EnumType.STRING)
    private SellerNivel sellerNivel;
    private String squad;
/*
    public Seller(Long id, LocalDate birthDate, BigDecimal salary, String contractType, String name, Department department, SellerNivel sellerNivel, String squad) {
        super(id, birthDate, salary, contractType, name, department);
        this.sellerNivel = sellerNivel;
        this.squad = squad;
    }*/

  public Seller(SellerDTO dto) {
     this.setDepartment(dto.getDepartment());
     this.setBirthDate(dto.getBirthDate());
     this.setContractType(dto.getContractType());
     this.setSalary(dto.getSalary());
     this.setName(dto.getName());
      sellerNivel = dto.getSellerNivel();
      squad = dto.getSquad();

  }

    public SellerNivel getSellerNivel() {
        return sellerNivel;
    }

    public void setSellerNivel(SellerNivel sellerNivel) {
        this.sellerNivel = sellerNivel;
    }

    public String getSquad() {
        return squad;
    }

    public void setSquad(String squad) {
        this.squad = squad;
    }
}

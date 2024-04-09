package com.limag.sistema_limag.dto;
import com.limag.sistema_limag.entities.Seller;
import com.limag.sistema_limag.enums.Department;
import com.limag.sistema_limag.enums.SellerNivel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SellerDTO {

    private Long id;
    private SellerNivel sellerNivel;
    private String squad;
    @Size(min = 5, max = 80, message = "Nome precisar ter de 5 a 80 caracteres")
    @NotBlank(message = "Favor informar o nome")
    private String name;
    @PastOrPresent(message = "O nascimento precisa ser anterior a data atual")
    private LocalDate birthDate;

    @Positive(message = "valor incorreto")
    private BigDecimal salary;
    private String contractType;
    private List<String> emails = new ArrayList<>();
    private Department department;


    public SellerDTO() {

    }

    public SellerDTO(Long id, SellerNivel sellerNivel, String squad, String name, LocalDate birthDate, BigDecimal salary, String contractType, List<String> emails, Department department) {
        this.id = id;
        this.sellerNivel = sellerNivel;
        this.squad = squad;
        this.name = name;
        this.birthDate = birthDate;
        this.salary = salary;
        this.contractType = contractType;
        this.emails = emails;
        this.department = department;
    }

    public SellerDTO(Seller entity) {
        id = entity.getId();
        sellerNivel = entity.getSellerNivel();
        squad = entity.getSquad();
        name = entity.getName();
        birthDate = entity.getBirthDate();
        salary = entity.getSalary();
        contractType = entity.getContractType();
        emails = entity.getEmails();
        department = entity.getDepartment();
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

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public String getContractType() {
        return contractType;
    }

    public List<String> getEmails() {
        return emails;
    }

    public Department getDepartment() {
        return department;
    }
}

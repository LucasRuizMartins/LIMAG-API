package com.limag.sistema_limag.dto;

import com.limag.sistema_limag.entities.Employee;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDTO {



    private Long id;

    @Size(min = 5, max = 80, message = "Nome precisar ter de 5 a 80 caracteres")
    @NotBlank(message = "Favor informar o nome")
    private String name;
    @PastOrPresent(message = "O nascimento precisa ser anterior a data atual")
    private LocalDate birthDate;

    private BigDecimal salary;
    private String contractType;
    private List<String> emails = new ArrayList<>();


    public EmployeeDTO() {

    }
    public EmployeeDTO(Employee entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.birthDate = entity.getBirthDate();
        this.salary = entity.getSalary();
        this.contractType = entity.getContractType();
        this.emails = entity.getEmails();
    }
    public EmployeeDTO(Long id, LocalDate birthDate, BigDecimal salary, String contractType, List<String> emails) {
        this.id = id;
        this.birthDate = birthDate;
        this.salary = salary;
        this.contractType = contractType;
        this.emails = emails;
    }

    public Long getId() {
        return id;
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
}

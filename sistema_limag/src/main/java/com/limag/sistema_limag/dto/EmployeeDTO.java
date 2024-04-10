package com.limag.sistema_limag.dto;

import com.limag.sistema_limag.entities.Employee;
import com.limag.sistema_limag.enums.Department;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
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
    private Department department;


    public EmployeeDTO(Employee entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.birthDate = entity.getBirthDate();
        this.salary = entity.getSalary();
        this.contractType = entity.getContractType();
        this.emails = entity.getEmails();
        this.department = entity.getDepartment();
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

    public Department getDepartment() {
        return department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDTO that = (EmployeeDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(birthDate, that.birthDate) && Objects.equals(salary, that.salary) && Objects.equals(contractType, that.contractType) && Objects.equals(emails, that.emails) && department == that.department;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthDate, salary, contractType, emails, department);
    }

}

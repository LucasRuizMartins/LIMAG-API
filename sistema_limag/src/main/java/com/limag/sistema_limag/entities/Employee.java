package com.limag.sistema_limag.entities;


import com.limag.sistema_limag.enums.Department;
import jakarta.persistence.*;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "tb_funcionarios")
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name ;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDate birthDate;
    private BigDecimal salary;
    private String contractType;

    @Enumerated(EnumType.STRING)
    private Department department;


    @ElementCollection
    @CollectionTable(name="tb_email_funcionarios")
    List<String> emails = new ArrayList<>();

    public Employee() {
    }
    public Employee(Long id, LocalDate birthDate, BigDecimal salary, String contractType, String name, Department department) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.salary = salary;
        this.contractType = contractType;
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Long getId() {
        return id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public void addEmail(String email) {
        emails.add(email);
    }

    public List<String> getEmails() {
        return new ArrayList<>(emails);
    }
}

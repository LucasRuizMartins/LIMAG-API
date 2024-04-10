package com.limag.sistema_limag.repositories;

import com.limag.sistema_limag.controllers.EmployeeController;
import com.limag.sistema_limag.dto.EmployeeDTO;
import com.limag.sistema_limag.entities.Employee;
import com.limag.sistema_limag.enums.Department;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import org.springframework.test.context.ActiveProfiles;


import static org.assertj.core.api.Assertions.assertThat;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;


@DataJpaTest
@ActiveProfiles("test")
class EmployeeRepositoryTest {
    @Autowired
    EntityManager entityManager;
    @Autowired
    EmployeeRepository repository;

    @Test
    @DisplayName("Shoud get user employee sucessfully from DB")
    void findEmployeeByNameSucess() {

       EmployeeDTO expectedDTO  = new EmployeeDTO(
               Long.valueOf(19),
               "Lucas Ruiz" ,
               LocalDate.of(1993,02,24),
               new BigDecimal("2850.00"),
               "CLT",
               Arrays.asList("ti4@limag.com.br", "email2@example.com") ,
               Department.TECNOLOGIA ) ;
       this.createEmployee(expectedDTO);

        Optional<Employee> result = this.repository.findEmployeeByName("Lucas Ruiz");
        assertThat(result.isPresent()).isTrue();
    }

    @Test
    @DisplayName("Shoud get user employee when employee not exists")
    void findEmployeeByNameFail() {
        Optional<Employee> result = this.repository.findEmployeeByName("Lucas Ruiz");
        assertThat(result.isEmpty()).isTrue();
    }

    private Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee newEmployee = new Employee(employeeDTO);
        return this.entityManager.merge(newEmployee);
    }

}
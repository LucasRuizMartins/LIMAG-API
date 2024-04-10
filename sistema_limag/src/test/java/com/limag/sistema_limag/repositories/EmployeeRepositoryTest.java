package com.limag.sistema_limag.repositories;


import com.limag.sistema_limag.dto.EmployeeDTO;
import com.limag.sistema_limag.entities.Employee;
import com.limag.sistema_limag.enums.Department;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@DataJpaTest
@ActiveProfiles("test")
class EmployeeRepositoryTest {
    @Autowired
    EntityManager entityManager;
    @Autowired
    EmployeeRepository repository;
    @BeforeEach
    public void setUp(){
        this.insertDataIntoBase();
    }

    @Test
    @DisplayName("Shoud get user employee sucessfully from DB")
    void findEmployeeByNameSucessCase() {
        Optional<Employee> result = this.repository.findEmployeeByName("Lucas Ruiz");
        assertThat(result.isPresent()).isTrue();
    }

    @Test
    @DisplayName("Should get user employee when employee not exists")
    void findEmployeeByNameFailCase() {
        Optional<Employee> result = this.repository.findEmployeeByName("Jose Ruiz");
        assertThat(result.isEmpty()).isTrue();
    }


    @Test
    @DisplayName("Should get Page of employee sucessfully from DB")
    void searchEmployeeByNameSucessCase(){
        Page<Employee> result = repository.searchByName("Lucas", Pageable.unpaged());
        assertThat(result.getContent()).hasSize(2);
    }

    @Test
    @DisplayName("Should not get Page of employee because search name is wrong")
    void searchEmployeeByNameFailCase(){

        Page<Employee> result = repository.searchByName("David", Pageable.unpaged());
        assertThat(result.getContent()).isNotEqualTo(2);
    }


    private void insertDataIntoBase(){
        List<EmployeeDTO> employees = new ArrayList<>();
        employees.add(new EmployeeDTO(19L,"Lucas Ruiz" ,LocalDate.of(1993,02,24),new BigDecimal("2850.00"),"CLT",Arrays.asList("teste@limag.com.br", "email2@example.com") ,Department.TECNOLOGIA ));
        employees.add(new EmployeeDTO(21L,"Lucas Silva" ,LocalDate.of(1995,03,21),new BigDecimal("2550.00"),"CLT",Arrays.asList("ex@limag.com.br", "email2@example.com") ,Department.COMPRAS ));

        employees.forEach(this::createEmployee);
    }

    private Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee newEmployee = new Employee(employeeDTO);
        return this.entityManager.merge(newEmployee);
    }

}
package com.limag.sistema_limag.services;


import com.limag.sistema_limag.dto.EmployeeDTO;
import com.limag.sistema_limag.entities.Employee;
import com.limag.sistema_limag.enums.Department;
import com.limag.sistema_limag.repositories.EmployeeRepository;
import com.limag.sistema_limag.services.exceptions.EmployeeNotFoundException;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import java.math.BigDecimal;
import java.time.LocalDate;

import java.util.*;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository repository;

    @InjectMocks
    private EmployeeService service;

    @Autowired
    EntityManager entityManager;

    Employee entity = new Employee();
    List<Employee> entities = new ArrayList<>();

    @BeforeEach
    void setUp(){
      this.setEntityEnviroments();
      this.insertEntitiesInList();
    }

    @Test
    @DisplayName("Should get employee By Id sucessfully from DB")
    void findByIdCaseSucess(){
        Long id = 1L;
        when(repository.findById(id)).thenReturn(Optional.of(entity));
        EmployeeDTO result = service.findById(id);

        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals("Eduardo Soares", result.getName());

        verify(repository).findById(entity.getId());
        verifyNoMoreInteractions(repository);
    }

    @Test
    @DisplayName("Should Fail to retrieve employee By Identification")
    void findByIdCaseFail(){
        Long id = 2L;
        when(repository.findById(id)).thenReturn(Optional.empty());
        assertThrows(EmployeeNotFoundException.class, () -> service.findById(id));
    }


    @Test
    @DisplayName("Should get Page of employee sucessfully from DB")
    void getEmployeePageSUCESSCase(){
        String name = "Eduardo";
        Pageable pageable = PageRequest.of(0, 10);
        Page<Employee> mockedPage = new PageImpl<>(entities, pageable, entities.size());
        when(repository.searchByName(name, pageable)).thenReturn(mockedPage);

        Page<EmployeeDTO> resultPage = service.findAll(name, pageable);

        assertThat(resultPage.getContent()).hasSize(2);
     }

    @Test
    @DisplayName("Should get Page of employee Fail")
    void getEmployeePageFAILCase(){
        String name = "Lucas";
        Pageable pageable = PageRequest.of(0, 10);
        Page<Employee> mockedPage = new PageImpl<>(entities, pageable, entities.size());
        when(repository.searchByName(name, pageable)).thenReturn(mockedPage);

        Page<EmployeeDTO> resultPage = service.findAll(name, pageable);

        assertThat(resultPage.getContent()).isNotEqualTo(2);
    }


void insertEntitiesInList(){
    this.entities.add(new Employee(new EmployeeDTO(10L,"Eduardo Soares" ,LocalDate.of(2005,03,21),new BigDecimal("4550.00"),"CLT",Arrays.asList("exA@limag.com.br", "email2@example.com") ,Department.TECNOLOGIA )));
    this.entities.add(new Employee(new EmployeeDTO(20L,"Eduardo Silva" ,LocalDate.of(1995,03,21),new BigDecimal("3550.00"),"PJ",Arrays.asList("exE@limag.com.br", "email3@example.com") ,Department.COMPRAS )));
}

    void setEntityEnviroments(){
        entity.setId(1L);
        entity.setName("Eduardo Soares");
        entity.setSalary(new BigDecimal("2000.00"));
        entity.setContractType("CLT");
        entity.setDepartment(Department.DIRETORIA);
        entity.setBirthDate(LocalDate.of(2006,04,15));
        entity.addEmail("ex@limag.com");


    }



}
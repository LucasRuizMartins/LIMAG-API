package com.limag.sistema_limag.services;

import com.limag.sistema_limag.dto.EmployeeDTO;
import com.limag.sistema_limag.entities.Employee;

import com.limag.sistema_limag.repositories.EmployeeRepository;
import com.limag.sistema_limag.services.exceptions.DatabaseException;
import com.limag.sistema_limag.services.exceptions.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Transactional(readOnly = true)
    public EmployeeDTO findById(Long id) {
        Employee employee = repository.findById(id).orElseThrow(
                () -> new EmployeeNotFoundException("Colaborador não encontrado"));
        return new EmployeeDTO(employee);
    }

    @Transactional(readOnly = true)
    public Page<EmployeeDTO> findAll(String name, Pageable pageable) {
        Page<Employee> result = repository.searchByName(name, pageable);
        return result.map(x -> new EmployeeDTO(x));
    }

    @Transactional
    public EmployeeDTO insert(EmployeeDTO dto) {
        Employee entity = new Employee();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new EmployeeDTO(entity);
    }


    @Transactional
    public EmployeeDTO update(Long id, EmployeeDTO dto) {
        try {
            Employee entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new EmployeeDTO(entity);
        }
        catch (EmployeeNotFoundException e) {
            throw new EmployeeNotFoundException("Colaborador não encontrado");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new EmployeeNotFoundException("Recurso não encontrado");
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    private void copyDtoToEntity(EmployeeDTO dto, Employee entity) {
        entity.setName(dto.getName());
        entity.setBirthDate(dto.getBirthDate());
        entity.setDepartment(dto.getDepartment());
        entity.setContractType(dto.getContractType());
        entity.setSalary(dto.getSalary());

    }

}

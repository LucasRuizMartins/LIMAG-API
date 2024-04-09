package com.limag.sistema_limag.services;

import com.limag.sistema_limag.dto.EmployeeDTO;
import com.limag.sistema_limag.dto.SellerDTO;
import com.limag.sistema_limag.entities.Employee;
import com.limag.sistema_limag.entities.Seller;
import com.limag.sistema_limag.repositories.EmployeeRepository;
import com.limag.sistema_limag.repositories.SellerRepository;
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
public class SellerService {

    @Autowired
    private SellerRepository repository;

    @Transactional(readOnly = true)
    public SellerDTO findById(Long id) {
        Seller seller = repository.findById(id).orElseThrow(
                () -> new EmployeeNotFoundException("Colaborador não encontrado"));
        return new SellerDTO(seller);
    }


    @Transactional(readOnly = true)
    public Page<SellerDTO> findAll(String name, Pageable pageable) {
        Page<Seller> result = repository.searchByName(name, pageable);
        return result.map(x -> new SellerDTO(x));
    }

    @Transactional
    public SellerDTO insert(SellerDTO dto) {
        Seller entity = new Seller();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new SellerDTO(entity);
    }


    @Transactional
    public SellerDTO update(Long id, SellerDTO dto) {
        try {
            Seller entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new SellerDTO(entity);
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

    private void copyDtoToEntity(SellerDTO dto, Seller entity) {
        entity.setSquad(dto.getSquad());
        entity.setSellerNivel(dto.getSellerNivel());

        // Atributos herdados do Employee
        entity.setName(dto.getName());
        entity.setBirthDate(dto.getBirthDate());
        entity.setSalary(dto.getSalary());
        entity.setContractType(dto.getContractType());
        dto.getEmails().forEach(email -> entity.addEmail(email));

        entity.setDepartment(dto.getDepartment());
     }

}

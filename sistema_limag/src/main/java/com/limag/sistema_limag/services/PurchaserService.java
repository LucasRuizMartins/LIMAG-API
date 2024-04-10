package com.limag.sistema_limag.services;

import com.limag.sistema_limag.dto.PurchaserDTO;
import com.limag.sistema_limag.entities.ClientGroup;
import com.limag.sistema_limag.entities.Purchaser;
import com.limag.sistema_limag.repositories.PurchaserRepository;
import com.limag.sistema_limag.services.exceptions.ClientNotFoundException;
import com.limag.sistema_limag.services.exceptions.DatabaseException;
import com.limag.sistema_limag.services.exceptions.PurchaserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PurchaserService {

    @Autowired
    private PurchaserRepository repository;

    @Transactional(readOnly = true)
    public PurchaserDTO findById(Long id) {
        Purchaser purchaser  = repository.findById(id).orElseThrow(
                () -> new PurchaserNotFoundException("Comprador não encontrado"));
        return new PurchaserDTO(purchaser);
    }

    @Transactional(readOnly = true)
    public Page<PurchaserDTO> findAll(String name, Pageable pageable) {
        Page<Purchaser> result = repository.searchByName(name, pageable);
        return result.map(x -> new PurchaserDTO(x));
    }

    @Transactional
    public PurchaserDTO insert(PurchaserDTO dto) {
        Purchaser entity = new Purchaser();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new PurchaserDTO(entity);
    }

    @Transactional
    public PurchaserDTO update(Long id, PurchaserDTO dto) {
        try {
            Purchaser entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new PurchaserDTO(entity);
        }
        catch (ClientNotFoundException e) {
            throw new PurchaserNotFoundException("Comprador não encontrado");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new PurchaserNotFoundException("Comprador não encontrado");
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    private void copyDtoToEntity(PurchaserDTO dto, Purchaser entity) {
        ClientGroup group = new ClientGroup();
        group.setName(dto.getClientGroup().getName());
        group.setId(dto.getClientGroup().getId());

        entity.setName(dto.getName());
        entity.setOrigin(dto.getOrigin());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setClientGroup(group);
        entity.setEmail(dto.getEmail());


     }

}

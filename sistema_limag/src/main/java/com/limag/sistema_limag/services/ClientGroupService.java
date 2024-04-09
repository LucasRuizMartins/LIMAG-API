package com.limag.sistema_limag.services;

import com.limag.sistema_limag.dto.ClientDTO;
import com.limag.sistema_limag.dto.ClientGroupDTO;
import com.limag.sistema_limag.entities.Client;
import com.limag.sistema_limag.entities.ClientGroup;
import com.limag.sistema_limag.repositories.ClientGroupRepository;
import com.limag.sistema_limag.repositories.ClientRepository;
import com.limag.sistema_limag.services.exceptions.ClientNotFoundException;
import com.limag.sistema_limag.services.exceptions.DatabaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientGroupService {

    @Autowired
    private ClientGroupRepository  repository;

    @Transactional(readOnly = true)
    public ClientGroupDTO findById(Long id) {
        ClientGroup client = repository.findById(id).orElseThrow(
                () -> new ClientNotFoundException("Cliente não encontrado"));
        return new ClientGroupDTO(client);
    }


    @Transactional(readOnly = true)
    public Page<ClientGroupDTO> findAll(String name, Pageable pageable) {
        Page<ClientGroup> result = repository.searchByName(name, pageable);
        return result.map(x -> new ClientGroupDTO(x));
    }

    @Transactional
    public ClientGroupDTO insert(ClientGroupDTO dto) {
        ClientGroup entity = new ClientGroup();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new ClientGroupDTO(entity);
    }


    @Transactional
    public ClientGroupDTO update(Long id, ClientGroupDTO dto) {
        try {
            ClientGroup entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new ClientGroupDTO(entity);
        }
        catch (ClientNotFoundException e) {
            throw new ClientNotFoundException("Cliente não encontrado");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ClientNotFoundException("Grupo não encontrado");
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    private void copyDtoToEntity(ClientGroupDTO dto, ClientGroup entity) {
        entity.setName(dto.getName());

     }

}

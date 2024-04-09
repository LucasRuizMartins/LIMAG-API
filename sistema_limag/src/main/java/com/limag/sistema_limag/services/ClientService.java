package com.limag.sistema_limag.services;

import com.limag.sistema_limag.dto.ClientDTO;
import com.limag.sistema_limag.dto.SellerDTO;
import com.limag.sistema_limag.entities.Client;
import com.limag.sistema_limag.entities.ClientGroup;
import com.limag.sistema_limag.entities.Seller;
import com.limag.sistema_limag.repositories.ClientRepository;
import com.limag.sistema_limag.repositories.SellerRepository;
import com.limag.sistema_limag.services.exceptions.ClientNotFoundException;
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
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client client = repository.findById(id).orElseThrow(
                () -> new ClientNotFoundException("Cliente não encontrado"));
        return new ClientDTO(client);
    }


    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(String name, Pageable pageable) {
        Page<Client> result = repository.searchByName(name, pageable);
        return result.map(x -> new ClientDTO(x));
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto) {
        Client entity = new Client();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new ClientDTO(entity);
    }


    @Transactional
    public ClientDTO update(Long id, ClientDTO dto) {
        try {
            Client entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new ClientDTO(entity);
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
            throw new ClientNotFoundException("Cliente não encontrado");
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    private void copyDtoToEntity(ClientDTO dto, Client entity) {
        ClientGroup group = new ClientGroup();
        group.setName(dto.getClientGroup().getName());
        group.setId(dto.getClientGroup().getId());


        entity.setClientGroup(group);
        entity.setAddress(dto.getAddress());

        entity.setName(dto.getName());

     }

}

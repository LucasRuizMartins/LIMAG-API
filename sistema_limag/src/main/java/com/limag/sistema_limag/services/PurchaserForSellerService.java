package com.limag.sistema_limag.services;

import com.limag.sistema_limag.dto.PurchaserDTO;
import com.limag.sistema_limag.dto.PurchaserForSellerDTO;
import com.limag.sistema_limag.entities.ClientGroup;
import com.limag.sistema_limag.entities.Purchaser;
import com.limag.sistema_limag.entities.PurchaserForSeller;
import com.limag.sistema_limag.entities.Seller;
import com.limag.sistema_limag.repositories.ClientGroupRepository;
import com.limag.sistema_limag.repositories.PurchaserForSellerRepository;
import com.limag.sistema_limag.repositories.PurchaserRepository;
import com.limag.sistema_limag.repositories.SellerRepository;
import com.limag.sistema_limag.services.exceptions.ClientNotFoundException;
import com.limag.sistema_limag.services.exceptions.DatabaseException;
import com.limag.sistema_limag.services.exceptions.PurchaserNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PurchaserForSellerService {

    @Autowired
    private PurchaserForSellerRepository repository;

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private PurchaserRepository purchaserRepository;

    @Autowired
    private ClientGroupRepository clientGroupRepository;



    @Transactional(readOnly = true)
    public Page<PurchaserForSellerDTO> findAll(Pageable pageable) {
        Page<PurchaserForSeller> result = repository.findAllPurchaserForSeller(pageable);
        return result.map(x -> new PurchaserForSellerDTO(x));
    }

    @Transactional(readOnly = true)
    public PurchaserForSellerDTO findById(Long id) {
        PurchaserForSeller purchaserForSeller  = repository.findById(id).orElseThrow(
                () -> new PurchaserNotFoundException("Comprador não encontrado"));
        return new PurchaserForSellerDTO(purchaserForSeller);
    }

    @Transactional
    public PurchaserForSellerDTO insert(PurchaserForSellerDTO dto) {
        PurchaserForSeller entity = new PurchaserForSeller(dto);
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new PurchaserForSellerDTO(entity);
    }

    @Transactional
    public PurchaserForSellerDTO update(Long id, PurchaserForSellerDTO dto) {
        try {
            PurchaserForSeller entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new PurchaserForSellerDTO(entity);
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


    private void copyDtoToEntity(PurchaserForSellerDTO dto, PurchaserForSeller entity) {

        Seller seller = sellerRepository.findById(dto.getSeller().getId())
                .orElseThrow(() -> new EntityNotFoundException("Seller não encontrado com o ID: " + dto.getSeller().getId()));
        Purchaser purchaser = purchaserRepository.findById(dto.getPurchaser().getId())
                .orElseThrow(() -> new EntityNotFoundException("Purchaser não encontrado com o ID: " + dto.getPurchaser().getId()));
        ClientGroup clientGroup = clientGroupRepository.findById(dto.getPurchaser().getClientGroup().getId())
                .orElseThrow(() -> new EntityNotFoundException("ClientGroup não encontrado com o ID: " + dto.getPurchaser().getClientGroup().getId()));


        entity.setPote(dto.getPote());
        entity.setReferenceDate(dto.getReferenceDate());
        entity.setSeller(seller);
        entity.setPurchaser(purchaser);
        purchaser.setClientGroup(clientGroup);
    }


}

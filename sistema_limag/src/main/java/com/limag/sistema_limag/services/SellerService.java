package com.limag.sistema_limag.services;

import com.limag.sistema_limag.dto.EmployeeDTO;
import com.limag.sistema_limag.dto.SellerDTO;
import com.limag.sistema_limag.entities.Employee;
import com.limag.sistema_limag.entities.Seller;
import com.limag.sistema_limag.repositories.EmployeeRepository;
import com.limag.sistema_limag.repositories.SellerRepository;
import com.limag.sistema_limag.services.exceptions.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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


}

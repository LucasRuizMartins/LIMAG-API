package com.limag.sistema_limag.repositories;

import com.limag.sistema_limag.entities.Employee;
import com.limag.sistema_limag.entities.Seller;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SellerRepository extends JpaRepository<Seller, Long> {

    @Query("SELECT obj FROM Seller obj " +
            "WHERE UPPER(obj.name) LIKE UPPER(CONCAT('%', :name, '%'))")
    Page<Seller> searchByName(String name, Pageable pageable);
}

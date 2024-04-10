package com.limag.sistema_limag.repositories;

import com.limag.sistema_limag.entities.Purchaser;
import com.limag.sistema_limag.entities.Seller;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PurchaserRepository extends JpaRepository<Purchaser, Long> {

    @Query("SELECT obj FROM Purchaser obj " +
            "WHERE UPPER(obj.name) LIKE UPPER(CONCAT('%', :name, '%'))")
    Page<Purchaser> searchByName(String name, Pageable pageable);
}

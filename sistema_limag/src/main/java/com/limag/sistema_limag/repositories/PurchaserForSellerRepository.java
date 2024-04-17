package com.limag.sistema_limag.repositories;

import com.limag.sistema_limag.entities.PurchaserForSeller;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PurchaserForSellerRepository extends JpaRepository<PurchaserForSeller, Long> {
    @Query("SELECT obj FROM PurchaserForSeller obj")
    Page<PurchaserForSeller> findAllPurchaserForSeller(Pageable pageable);
}

package com.limag.sistema_limag.repositories;

import com.limag.sistema_limag.entities.Employee;
import com.limag.sistema_limag.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}

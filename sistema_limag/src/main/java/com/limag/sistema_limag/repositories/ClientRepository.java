package com.limag.sistema_limag.repositories;

import com.limag.sistema_limag.entities.Client;
import com.limag.sistema_limag.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepository extends JpaRepository<Client,Long> {

    @Query("SELECT obj FROM Client obj " +
            "WHERE UPPER(obj.name) LIKE UPPER(CONCAT('%', :name, '%'))")
    Page<Client> searchByName(String name, Pageable pageable);
}

package com.limag.sistema_limag.repositories;

import com.limag.sistema_limag.entities.Client;
import com.limag.sistema_limag.entities.ClientGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientGroupRepository extends JpaRepository<ClientGroup,Long> {

    @Query("SELECT obj FROM ClientGroup obj " +
            "WHERE UPPER(obj.name) LIKE UPPER(CONCAT('%', :name, '%'))")
    Page<ClientGroup> searchByName(String name, Pageable pageable);
}

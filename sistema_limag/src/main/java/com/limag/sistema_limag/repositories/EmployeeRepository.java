package com.limag.sistema_limag.repositories;

import com.limag.sistema_limag.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

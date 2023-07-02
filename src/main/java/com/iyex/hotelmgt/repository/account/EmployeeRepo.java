package com.iyex.hotelmgt.repository.account;

import com.iyex.hotelmgt.domain.account.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    Employee findEmployeeByUsername(String username);
}

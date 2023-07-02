package com.iyex.hotelmgt.service.account;

import com.iyex.hotelmgt.domain.account.Employee;
import com.iyex.hotelmgt.repository.account.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    public Employee getEmployee(Long id){
        return employeeRepo.findById(id).orElseThrow(()-> new NoSuchElementException("Employee with id " + id + " not found"));
    }
    public List<Employee> getAllEmployee(){
        return employeeRepo.findAll();
    }

    public Employee saveEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

//    public Employee updateEmployee(Long id, Employee employee){
//        return employeeRepo.save(employee);
//    }


    public Employee getEmployeeByUsername(String username) {
        return employeeRepo.findEmployeeByUsername(username);
    }

    public String deleteEmployee(Long id){
         employeeRepo.deleteById(id);
        return "Employee with id " + id + " was Deleted";
    }
}

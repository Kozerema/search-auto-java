package ua.com.searchauto.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.searchauto.models.Employee;

public interface EmployeeDAO extends JpaRepository<Employee,Integer> {
}

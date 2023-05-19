package ua.com.searchauto.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.searchauto.dao.EmployeeDAO;
import ua.com.searchauto.models.Employee;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {
    EmployeeDAO employeeDAO;

    public void saveEmployee(Employee employee) {
        if (employee == null) {
            throw new RuntimeException();
        }
        employeeDAO.save(employee);
    }

    public List<Employee> getAllEmployee() {

        return employeeDAO.findAll();
    }


    public Employee getOneEmployee(int id) {

        if (id > 0) {

          return employeeDAO.findById(id).get();
        }

        throw new RuntimeException();
    }

    public Employee updateEmployee(int id, Employee employee) {
        Employee employee1 = employeeDAO.findById(id).get();
        employee1.setAge(employee.getAge());
        employee1.setName(employee.getName());
        employee1.setSurname(employee.getSurname());
        employee1.setEmail(employee.getEmail());
        employeeDAO.save(employee1);
        return employee1;
    }

    public void deleteEmployee(int id) {
       employeeDAO.deleteById(id);
    }

}

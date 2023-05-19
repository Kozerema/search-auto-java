package ua.com.searchauto.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.searchauto.models.Employee;
import ua.com.searchauto.services.EmployeeService;

import java.util.List;

@RestController
@AllArgsConstructor
public class EmployeeController {
    EmployeeService employeeService;

    @PostMapping("/admins/employees")
    @ResponseStatus(HttpStatus.OK)
    public void saveAuto(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
    }

    @GetMapping("/admins/findEmployees")
    public ResponseEntity<List<Employee>> getEmployees() {

        return new ResponseEntity<List<Employee>>(employeeService.getAllEmployee(), HttpStatus.OK);
    }


    @GetMapping("/admins/findOneEmployees/{id}")
    public Employee getOneEmployee(@PathVariable("id") int id) {
        return employeeService.getOneEmployee(id);
    }


    @PatchMapping("/admins/employees/{id}")
    public Employee updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/admins/employees/{id}")
    public void deleteEmployee(@PathVariable("id") int id) {
         employeeService.deleteEmployee(id);
    }
}

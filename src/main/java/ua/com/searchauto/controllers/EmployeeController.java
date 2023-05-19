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

    @PostMapping("/admin/employee")
    @ResponseStatus(HttpStatus.OK)
    public void saveAuto(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
    }

    @GetMapping("/admin/findEmployees")
    public ResponseEntity<List<Employee>> getEmployees() {

        return new ResponseEntity<List<Employee>>(employeeService.getAllEmployee(), HttpStatus.OK);
    }


    @GetMapping("/admin/findOneEmployee/{id}")
    public Employee getOneEmployee(@PathVariable("id") int id) {
        return employeeService.getOneEmployee(id);
    }


    @PatchMapping("/admin/employee/{id}")
    public Employee updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/admin/employee/{id}")
    public void deleteEmployee(@PathVariable("id") int id) {
         employeeService.deleteEmployee(id);
    }
}

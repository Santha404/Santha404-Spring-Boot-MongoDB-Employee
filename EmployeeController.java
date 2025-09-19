package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/save")
    public Employee save(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("/displayAll")
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @GetMapping("/display/{id}")
    public Optional<Employee> getById(@PathVariable String id) {
        return employeeRepository.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        employeeRepository.deleteById(id);
        return "Employee deleted successfully!";
    }
}

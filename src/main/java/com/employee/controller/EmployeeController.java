package com.employee.controller;
import com.employee.model.Employee;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin
public class EmployeeController {
    @Autowired
    private EmployeeService service;
    @GetMapping
    public List<Employee> getAll() { return service.getAll(); }
    @PostMapping
    public Employee create(@RequestBody Employee e) { return service.save(e); }
    @GetMapping("/{id}")
    public Employee getOne(@PathVariable Long id) { return service.getById(id); }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}

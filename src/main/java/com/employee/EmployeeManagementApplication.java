package com.employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import java.util.Arrays;

@SpringBootApplication
public class EmployeeManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(EmployeeRepository repo) {
        return args -> {
            repo.deleteAll();
            repo.saveAll(Arrays.asList(
                    createEmp("Anuj Sharma", "anuj@gmail.com", "Developer", "6263671144", 50000.0),
                    createEmp("Amit Verma", "amit@gmail.com", "Developer", "6263671141", 55000.0),
                    createEmp("Priya Sharma", "priya@gmail.com", "HR", "6263671142", 45000.0),
                    createEmp("Rahul Singh", "rahul@gmail.com", "Testing", "6263671143", 50000.0),
                    createEmp("Neha Patel", "neha@gmail.com", "Designer", "6263671144", 60000.0),
                    createEmp("Vikash Yadav", "vikash@gmail.com", "Developer", "6263671145", 65000.0)
            ));
            System.out.println("6 Members Added Successfully!");
        };
    }

    private Employee createEmp(String name, String email, String dept, String phone, Double salary) {
        Employee e = new Employee();
        e.setName(name);
        e.setEmail(email);
        e.setDepartment(dept);
        e.setPhone(phone);
        e.setSalary(salary);
        return e;
    }
}
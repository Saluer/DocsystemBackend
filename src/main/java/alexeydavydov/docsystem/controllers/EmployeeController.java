package alexeydavydov.docsystem.controllers;

import alexeydavydov.docsystem.domain.Employee;
import alexeydavydov.docsystem.services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final Logger log = LoggerFactory.getLogger(EmployeeController.class);
    private final EmployeeService employeeService;

    EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("")
    public List<Employee> allEmployees() {
        log.info("Получен запрос на получение всех сотрудников");

        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Employee> findEmployeeById(@PathVariable("id") int id) {
        log.info("Получен запрос на получение сотрудника по id: " + id);

        return employeeService.findById(id);
    }

}

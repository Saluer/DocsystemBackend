package alexeydavydov.docsystem.controllers.api;

import alexeydavydov.docsystem.domain.Employee;
import alexeydavydov.docsystem.services.EmployeeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/employees")
public class EmployeeApiController {

    private final EmployeeService employeeService;

    EmployeeApiController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("")
    public List<Employee> allEmployees() {
        return employeeService.findAll();
    }

}

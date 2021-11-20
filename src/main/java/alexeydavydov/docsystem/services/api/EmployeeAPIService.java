package alexeydavydov.docsystem.services.api;

import alexeydavydov.docsystem.domain.Employee;
import alexeydavydov.docsystem.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeAPIService {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeAPIService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<Employee> findAll() {
        return employeeService.findAll();
    }

}

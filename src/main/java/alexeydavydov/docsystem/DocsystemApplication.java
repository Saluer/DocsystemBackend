package alexeydavydov.docsystem;

import alexeydavydov.docsystem.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class DocsystemApplication {

    @Autowired
    private EmployeeService employeeService;
    private static final Logger log = LoggerFactory.getLogger(DocsystemApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DocsystemApplication.class, args);
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void testJpaMethods() {
//        Employee employee = new Employee();
//        employee.setFirstname("Alex");
//        employee.setSurname("Mason");
//        employee.setPatronymic("Kirillovich");
//        employee.setPosition("Principal");
//
//        employeeService.createEmployee(employee);
//        employeeService.findAll().forEach(emp -> System.out.println(emp));
//    }

}

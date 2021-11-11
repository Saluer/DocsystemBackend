package alexeydavydov.docsystem;

import alexeydavydov.docsystem.model.Employee;
import alexeydavydov.docsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class DocsystemApplication {

    @Autowired
    private EmployeeService employeeService;
    private static final Logger log = LoggerFactory.getLogger(DocsystemApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DocsystemApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void testJpaMethods(){
        Employee employee = new Employee();
        employee.setFirstname("Alex");
        employee.setSurname("Mason");
        employee.setPatronymic("Kirillovich");
        employee.setPosition("Principal");

        employeeService.createEmployee(employee);
        log.info("Info");
        /*Address address = new Address();
        address.setCity("Kiev");
        address.setHomeNumber("4");
        address.setStreet("Main Street");
        Address address1 = new Address();
        address1.setCity("Lviv");
        Users users = new Users();
        users.setAddress(address);
        users.setEmail("someEmail@gmail.com");
        users.setName("Smith");
        userService.createUsers(users);
        Users users1 = new Users();
        users1.setName("Jon Dorian");
        users1.setEmail("gmailEmail@gmail.com");
        users1.setAddress(address1);
        userService.createUsers(users1);

        userService.findAll().forEach(it-> System.out.println(it));

        userService.findAllByName("Smith").forEach(it-> System.out.println(it));

        userService.findWhereEmailIsGmail().forEach(it-> System.out.println(it));

        userService.findWhereNameStartsFromSmith().forEach(it-> System.out.println(it));*/
    }

}

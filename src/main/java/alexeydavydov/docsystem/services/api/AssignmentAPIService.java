package alexeydavydov.docsystem.services.api;

import alexeydavydov.docsystem.DocsystemApplication;
import alexeydavydov.docsystem.domain.Assignment;
import alexeydavydov.docsystem.domain.Employee;
import alexeydavydov.docsystem.requests.CreateAssignmentRequest;
import alexeydavydov.docsystem.services.AssignmentService;
import alexeydavydov.docsystem.services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentAPIService {

    //TODO убрать по возможности заглушку
    final int myId = 1;

    private final AssignmentService assignmentService;
    private final EmployeeService employeeService;


    @Autowired
    public AssignmentAPIService(AssignmentService assignmentService, EmployeeService employeeService) {
        this.assignmentService = assignmentService;
        this.employeeService = employeeService;
    }

    public List<Assignment> findAll() {
        return assignmentService.findAll();
    }

    public List<Assignment> findAssignmentsFromMe() {
        Optional<Employee> optionalEmployee = employeeService.findById(myId);
        if (optionalEmployee.isPresent()) {
            Employee me = employeeService.findById(myId).get();
            return assignmentService.findByAuthor(me);
        } else return null;
    }

    public List<Assignment> findAssignmentsToMe() {
        Optional<Employee> optionalEmployee = employeeService.findById(myId);
        if (optionalEmployee.isPresent()) {
            Employee me = employeeService.findById(myId).get();
            return assignmentService.findByOperatorsContaining(me);
        } else return null;
    }

    public Assignment createAssignment(@RequestBody CreateAssignmentRequest request) {
        Optional<Employee> author = employeeService.findById(request.getAuthorId());
        Assignment assignment = new Assignment();
        return assignmentService.create(assignment);
    }
}

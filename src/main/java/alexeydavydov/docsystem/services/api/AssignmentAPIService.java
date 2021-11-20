package alexeydavydov.docsystem.services.api;

import alexeydavydov.docsystem.domain.Assignment;
import alexeydavydov.docsystem.domain.Employee;
import alexeydavydov.docsystem.requests.CreateAssignmentRequest;
import alexeydavydov.docsystem.requests.UpdateAssignmentRequest;
import alexeydavydov.docsystem.services.AssignmentService;
import alexeydavydov.docsystem.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Assignment findAssignmentById(int id) {
        return assignmentService.findById(id);
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

    public Assignment createAssignment(CreateAssignmentRequest request) {
        Optional<Employee> author = employeeService.findById(request.getAuthorId());
        Assignment assignment = new Assignment();
        assignment.setAuthor(author.get());
        assignment.setContent(request.getContent());
        assignment.setSubject(request.getSubject());
        assignment.setDeadline(request.getDeadline());
        assignment.setControlSign(request.isControlSign());
        assignment.setOperateSign(request.isOperateSign());
        return assignmentService.create(assignment);
    }

    public Assignment updateAssignment(int id, UpdateAssignmentRequest request) {
        Optional<Employee> author = employeeService.findById(request.getAuthorId());
        Assignment assignment = new Assignment();
        assignment.setId(id);
        assignment.setAuthor(author.get());
        assignment.setContent(request.getContent());
        assignment.setSubject(request.getSubject());
        assignment.setDeadline(request.getDeadline());
        assignment.setControlSign(request.isControlSign());
        assignment.setOperateSign(request.isOperateSign());
        return assignmentService.update(assignment);
    }

    public void deleteAssignment(int id) {
        Assignment assignment = assignmentService.findById(id);
        assignmentService.delete(assignment);
    }
}

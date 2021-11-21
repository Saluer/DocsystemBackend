package alexeydavydov.docsystem.services;

import alexeydavydov.docsystem.domain.Assignment;
import alexeydavydov.docsystem.domain.Employee;
import alexeydavydov.docsystem.repositories.AssignmentRepository;
import alexeydavydov.docsystem.requests.CreateAssignmentRequest;
import alexeydavydov.docsystem.requests.UpdateAssignmentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {
    //TODO убрать по возможности заглушку
    final int myId = 1;
    private final AssignmentRepository assignmentRepository;
    private final EmployeeService employeeService;

    @Autowired
    public AssignmentService(AssignmentRepository assignmentRepository, EmployeeService employeeService) {
        this.assignmentRepository = assignmentRepository;
        this.employeeService = employeeService;
    }

    public List<Assignment> findAssignmentsFromMe() {
        Employee me = employeeService.findById(myId).get();
        return this.findByAuthor(me);
    }

    public List<Assignment> findAssignmentsToMe() {
        Employee me = employeeService.findById(myId).get();
        return this.findByOperatorsContaining(me);
    }

    public List<Assignment> findAll() {
        return assignmentRepository.findAll();
    }


    public Assignment createAssignment(CreateAssignmentRequest request) {
        Optional<Employee> author = employeeService.findById(request.getAuthorId());
        Assignment assignment = new Assignment(request, author.get());
        return assignmentRepository.save(assignment);
    }

    public Assignment updateAssignment(int id, UpdateAssignmentRequest request) {
        Optional<Employee> author = employeeService.findById(request.getAuthorId());
        Assignment assignment = new Assignment(request, id, author.get());
        return assignmentRepository.save(assignment);
    }

    public void deleteAssignment(int id) {
        Assignment assignment = this.findById(id);
        assignmentRepository.delete(assignment);
    }

    public Assignment findById(int id) {
        return this.assignmentRepository.findById(id);
    }

    public List<Assignment> findByAuthor(Employee author) {
        return this.assignmentRepository.findByAuthor(author);
    }

    public List<Assignment> findByOperatorsContaining(Employee employee) {
        return assignmentRepository.findByOperatorsContaining(employee);
    }
}

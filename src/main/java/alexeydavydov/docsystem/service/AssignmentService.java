package alexeydavydov.docsystem.service;

import alexeydavydov.docsystem.model.Assignment;
import alexeydavydov.docsystem.model.Employee;
import alexeydavydov.docsystem.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {
    private final AssignmentRepository assignmentRepository;
    //Сомнительно
    private final EmployeeService employeeService;


    @Autowired
    public AssignmentService(AssignmentRepository assignmentRepository, EmployeeService employeeService) {
        this.assignmentRepository = assignmentRepository;
        this.employeeService = employeeService;
    }

    public List<Assignment> findAll() {
        return assignmentRepository.findAll();
    }

    //TODO убрать по возможности заглушку
    final int myId = 0;

    public List<Assignment> findAssignmentsFromMe() {
        Optional<Employee> optionalEmployee = employeeService.findById(myId);
        if (optionalEmployee.isPresent()) {
            Employee me = employeeService.findById(myId).get();
            return assignmentRepository.findByAuthor(me);
        } else return null;
    }

    public List<Assignment> findAssignmentsToMe() {
        Optional<Employee> optionalEmployee = employeeService.findById(myId);
        if (optionalEmployee.isPresent()) {
            Employee me = employeeService.findById(myId).get();
            return assignmentRepository.findByOperatorsContaining(me);
        } else return null;
    }
}

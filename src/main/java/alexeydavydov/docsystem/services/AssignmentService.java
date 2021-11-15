package alexeydavydov.docsystem.services;

import alexeydavydov.docsystem.domain.Assignment;
import alexeydavydov.docsystem.domain.Employee;
import alexeydavydov.docsystem.repositories.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;

    @Autowired
    public AssignmentService(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;

    }

    public List<Assignment> findAll() {
        return assignmentRepository.findAll();
    }

    public List<Assignment> findByAuthor(Employee author) {
        return this.assignmentRepository.findByAuthor(author);
    }

    public List<Assignment> findByOperatorsContaining(Employee operator) {
        return this.assignmentRepository.findByOperatorsContaining(operator);
    }
}

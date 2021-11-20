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

    public Assignment findById(int id) {
        return this.assignmentRepository.findById(id);
    }

    public List<Assignment> findByAuthor(Employee author) {
        return this.assignmentRepository.findByAuthor(author);
    }

    public List<Assignment> findByOperatorsContaining(Employee employee) {
        return assignmentRepository.findByOperatorsContaining(employee);
    }

    public Assignment create(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public Assignment update(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public void delete(Assignment assignment) {
        assignmentRepository.delete(assignment);
    }

}

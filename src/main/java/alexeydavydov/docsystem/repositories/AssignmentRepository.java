package alexeydavydov.docsystem.repositories;

import alexeydavydov.docsystem.domain.Assignment;
import alexeydavydov.docsystem.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {

    Assignment findById(int id);

    List<Assignment> findByAuthor(Employee author);

    List<Assignment> findByOperatorsContaining(Employee employee);

}

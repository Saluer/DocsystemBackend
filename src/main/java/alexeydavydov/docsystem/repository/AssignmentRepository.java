package alexeydavydov.docsystem.repository;

import alexeydavydov.docsystem.model.Assignment;
import alexeydavydov.docsystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {

    List<Assignment> findByAuthor(Employee author);


    List<Assignment> findByOperatorsContaining(Employee employee);

}

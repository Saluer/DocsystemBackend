package alexeydavydov.docsystem.repository;

import alexeydavydov.docsystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findAllByFirstname(String firstname);

    Employee findByFirstname(String firstname);

    @Transactional
    @Modifying
    @Query("update Employee e set e.firstname = :firstname where e.id = :id")
    void setFirstname(@Param("firstname") String firstname, @Param("id") int id);


}
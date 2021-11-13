package alexeydavydov.docsystem.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private int id;

    @Column
    private String firstname;

    @Column
    private String surname;

    @Column
    private String patronymic;

    @Column
    private String position;

    @OneToOne
    private Organization organization;

    @OneToOne
    private Department department;

    @OneToMany
    private List<Assignment> assignmentsFromEmployee;

    @ManyToOne
    private Assignment assignmentForEmployee;

    @Override
    public String toString() {
        return "Работник. ФИО: " + this.firstname + " " + this.surname + " " + this.patronymic + ". Должность — " + this.position + ". ";
    }

}

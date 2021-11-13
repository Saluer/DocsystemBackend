package alexeydavydov.docsystem.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private int id;

    @Column
    private String subject;

    @Column
    private Date deadline;

    @Column
    private boolean controlSign;

    @Column
    private boolean operateSign;

    @Column
    private String content;

    @ManyToOne
    private Employee author;

    @OneToMany
    private List<Employee> operators;


}

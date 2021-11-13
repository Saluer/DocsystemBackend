package alexeydavydov.docsystem.model;

import javax.persistence.*;

@Entity
@Table
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private int id;

    @Column
    private String name;

    @Column
    private String physAddress;

    @Column
    private String jureAddress;

    @OneToOne
    private Employee director;

}

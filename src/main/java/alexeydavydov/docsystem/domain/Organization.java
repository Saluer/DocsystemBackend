package alexeydavydov.docsystem.domain;

import javax.persistence.*;
import java.util.List;

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


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhysAddress() {
        return physAddress;
    }

    public void setPhysAddress(String physAddress) {
        this.physAddress = physAddress;
    }

    public String getJureAddress() {
        return jureAddress;
    }

    public void setJureAddress(String jureAddress) {
        this.jureAddress = jureAddress;
    }

    public Employee getDirector() {
        return director;
    }

    public void setDirector(Employee director) {
        this.director = director;
    }
}

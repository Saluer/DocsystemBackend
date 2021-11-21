package alexeydavydov.docsystem.domain;

import alexeydavydov.docsystem.requests.CreateAssignmentRequest;
import alexeydavydov.docsystem.requests.UpdateAssignmentRequest;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;


//TODO сделать так, чтобы связь от n к m была уникальной и нельзя было создать такой более одной. (unique?)
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

    @ManyToMany
    private List<Employee> operators;

    @ManyToOne
    private Employee author;


    public Assignment() {
    }

    public Assignment(CreateAssignmentRequest request, Employee author) {
        this.subject = request.getSubject();
        this.deadline = request.getDeadline();
        this.controlSign = request.isControlSign();
        this.operateSign = request.isOperateSign();
        this.content = request.getContent();
        this.author = author;
    }

    public Assignment(UpdateAssignmentRequest request, int id, Employee author) {
        this.id = id;
        this.subject = request.getSubject();
        this.deadline = request.getDeadline();
        this.controlSign = request.isControlSign();
        this.operateSign = request.isOperateSign();
        this.content = request.getContent();
        this.author = author;
    }

    public Employee getAuthor() {
        return author;
    }

    public void setAuthor(Employee author) {
        this.author = author;
    }

    public List<Employee> getOperators() {
        return operators;
    }

    public void setOperators(List<Employee> operators) {
        this.operators = operators;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public boolean isControlSign() {
        return controlSign;
    }

    public void setControlSign(boolean controlSign) {
        this.controlSign = controlSign;
    }

    public boolean isOperateSign() {
        return operateSign;
    }

    public void setOperateSign(boolean operateSign) {
        this.operateSign = operateSign;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}

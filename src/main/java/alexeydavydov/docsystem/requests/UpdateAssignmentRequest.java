package alexeydavydov.docsystem.requests;

import java.sql.Date;

public class UpdateAssignmentRequest {
    private String subject;
    private Date deadline;
    private boolean controlSign;
    private boolean operateSign;
    private String content;
    private int authorId;


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

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}

package model;

/**
 *
 * @author Thiều Văn Tuấn
 */
import java.io.Serializable;

public class Answer implements Serializable {

    static final long serialVersionUID = 21L;
    Student student;

    public Answer() {
    }

    public Answer(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}

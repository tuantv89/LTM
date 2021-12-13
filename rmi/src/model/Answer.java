package model;

/**
 *
 * @author Thiều Văn Tuấn
 */
import java.io.Serializable;
import model.Student;

public class Answer implements Serializable {

    static final long serialVersionUID = 2L;
    Student student;
    boolean isAlreadyRegistration = false;

    public Answer() {
    }

    public Answer(Student student) {
        this.student = student;
    }

    public boolean isIsAlreadyRegistration() {
        return this.isAlreadyRegistration;
    }

    public void setIsAlreadyRegistration(boolean isAlreadyRegistration) {
        this.isAlreadyRegistration = isAlreadyRegistration;
    }

    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}

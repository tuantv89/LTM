package control;

/**
 *
 * @author Thiều Văn Tuấn
 */
import java.rmi.Remote;
import java.rmi.RemoteException;
import model.Answer;
import model.Student;

public interface IRegistration extends Remote {

    public Student register(Student s) throws RemoteException;

    public Answer answer(Answer a) throws RemoteException;
}


/**
 *
 * @author Thiều Văn Tuấn
 */
import java.net.InetAddress;
import java.util.Date;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class main {

    public Session createSession() {
        final String username = "xxxxx@gmail.com";
        final String password = "******";
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        return session;
    }

    public Message createMessage(Session sess) throws MessagingException {
        Message mess = new MimeMessage(sess);
        mess.setFrom(new InternetAddress("tvtuan0411@gmail.com"));
        mess.setRecipients(Message.RecipientType.TO, InternetAddress.parse("laptrinhmangptit@gmail.com", false));
        mess.setSubject("9 - B18DCAT217 - Thiều Văn Tuấn");
        mess.setText("Điểm danh");
        mess.setSentDate(new Date());
        return mess;
    }

    public static void main(String[] args) {
        main m = new main();
        Session sess = m.createSession();
        try {
            Message mess = m.createMessage(sess);
            Transport.send(mess);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}

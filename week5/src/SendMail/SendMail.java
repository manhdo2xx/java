package SendMail;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class SendMail {
    static String emailReceipients = "";
    static String emailSubject = "";
    static String emailBody = "";
    Session newSession = null;
    MimeMessage mimeMessage = null;

    public static void main(String[] args) throws MessagingException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập email: ");
        emailReceipients = sc.nextLine();
        System.out.println("Nhập tiêu đề : ");
        emailSubject = sc.nextLine();
        System.out.println("Nhập nội dung : ");
        emailBody = sc.nextLine();
        SendMail m = new SendMail();
        m.setupServerProperties();
        m.draftEmail();
        m.sendMail();
    }


    private void setupServerProperties() {
        Properties properties = System.getProperties();
        properties.put("mail.stmp.port", "547");
        properties.put("mail.stmp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        newSession = Session.getDefaultInstance(properties, null);
    }

    private void draftEmail() throws MessagingException {
        mimeMessage = new MimeMessage(newSession);
        mimeMessage.setRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(emailReceipients)));
        mimeMessage.setSubject(emailSubject);
        mimeMessage.setText(emailBody);
    }

    private void sendMail() throws MessagingException {
        final String from = "Manhdo1082001@gmail.com";
        Properties config = new Properties();
        try (InputStream input = new FileInputStream("C:\\Users\\manh.do\\Desktop\\ManhTTS\\week5\\src\\SendMail\\config.properties")) {
            config.load(input);
            final String password = config.getProperty("email.password");
            String emailHost = "smtp.gmail.com";
            Transport transport = newSession.getTransport("smtp");
            transport.connect(emailHost, from, password);
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            transport.close();
            System.out.println("Email successfully sent");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

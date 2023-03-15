import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import java.util.Properties;

public class GmailReader {
    public static void main(String[] args) {
        String username = "your_username@gmail.com";
        String password = "your_password";
        Properties props = new Properties();
        props.setProperty("mail.imap.ssl.enable", "true");

        try {
            Session session = Session.getInstance(props, null);
            Store store = session.getStore("imap");
            store.connect("imap.gmail.com", username, password);

            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            Message[] messages = inbox.getMessages(inbox.getMessageCount(), inbox.getMessageCount());
            // Fetch only the last message

            for (Message message : messages) {
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0].toString());
                System.out.println("Sent Date: " + message.getSentDate());
                System.out.println("Message: " + message.getContent().toString());
            }

            inbox.close(false);
            store.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


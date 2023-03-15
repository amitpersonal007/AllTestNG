import javax.mail.*;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GmailReader {
    public static void main(String[] args) {
        String host = "imap.gmail.com";
        String port = "993";
        String username = "amitsamsungtest@gmail.com\n";  //kcsdqa@gmail.com / HouseAcrossTheRiverNoida

        String password = "gwrlglvldwjtgidr";  //


        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        props.setProperty("mail.imaps.host", host);
        props.setProperty("mail.imaps.port", port);
        props.setProperty("mail.imaps.auth", "true");
        props.setProperty("mail.imap.ssl.protocols", "TLSv1.2");
        props.setProperty("mail.imap.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        try {
            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            Store store = session.getStore("imaps");
            store.connect(host, username, password);

            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            Message[] messages = inbox.getMessages();
            Message latestMessage = messages[messages.length - 1];

            Object content = latestMessage.getContent();
            Multipart multipart = (Multipart) content;
            BodyPart bodyPart = multipart.getBodyPart(0);



            String FullMessage = (String) bodyPart.getContent();
            System.out.println(FullMessage);
            Pattern pattern = Pattern.compile("(?s)PIN\\s*(\\d+)");
            Matcher matcher = pattern.matcher(FullMessage);

            if (matcher.find()) {
                String otp = matcher.group(1);
                System.out.println("OTP is "+otp);
            } else {
                System.out.println("NOT OTP");
            }

            //System.out.println("Subject: " + latestMessage.getSubject());
            inbox.close(false);
            store.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}

import javax.mail.*;
import java.util.Properties;

public class EmailFetch {
    public static void main(String[] args) {
        String host = "imap.gmail.com";
        String port = "993";
        String username = "usertestsigma@cloudbyz.com";
        String password = "cwvbarlmeuvgvoxo";

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
           // System.out.println(content);
            BodyPart bodyPart = null;
            String FullMessage = null;
            if (content instanceof String) {
               // System.out.println(content);
                FullMessage = (String) content;
            } else if (content instanceof Multipart) {
                // content is already a Multipart object, so just cast it and process the body part
                Multipart multipart = (Multipart) content;
                bodyPart = multipart.getBodyPart(0);
                FullMessage = (String) bodyPart.getContent();
                // process the body part as needed
            } else {
                System.out.println("No content");
            }

            //System.out.println(FullMessage);
//            Pattern pattern = Pattern.compile("\\d+");
//           // Pattern pattern = Pattern.compile("(?s)PIN\\s*(\\d+)");
//            Matcher matcher = pattern.matcher(FullMessage);

            String verificationCodePrefix = "Verification Code: ";
            int verificationCodeIndex = FullMessage.indexOf(verificationCodePrefix);

            if (verificationCodeIndex != -1) {
                int verificationCodeStartIndex = verificationCodeIndex + verificationCodePrefix.length();
                String verificationCode = FullMessage.substring(verificationCodeStartIndex, verificationCodeStartIndex + 6);
                System.out.println(verificationCode);
            } else {
                System.out.println("Verification code not found.");
            }



//            if (matcher.find()) {
//                String otp = matcher.group(1);
//                System.out.println("PIN is " + otp);
//            } else {
//                System.out.println("NOT A PIN");
//            }
            // check if the pattern matched any groups before trying to access them
//            if (matcher.matches() && matcher.groupCount() >= 1) {
//                String code = matcher.group(1);
//                System.out.println("Verification code: " + code);
//            } else {
//                System.out.println("Verification code not found.");
//            }

            //System.out.println("Subject: " + latestMessage.getSubject());
            inbox.close(false);
            store.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}

package com.nazarov.radioPlayer.updates;

import com.nazarov.radioPlayer.RadioApplication;
import com.nazarov.radioPlayer.config.ConfigReader;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Properties;

public class MailSender {

    ConfigReader configReader = new ConfigReader();

    public static void main(String[] args) {
        MailSender mailSender = new MailSender();
        mailSender.sendEmail("Trollolo", "NewPlaylist/8bit_RadioSure.txt");
    }
    public void sendEmail(String subject, String attachmentName) {
        // Defines the E-Mail information.
        String from = configReader.getEmail();
        String to = configReader.getEmail();
        String fileName = attachmentName.split("/")[1];
        String bodyText = subject + " - " + fileName;

        // Creates a Session with the following properties.
        Properties props = new Properties();
//        For gmail:
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.transport.protocol", "smtp");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.port", "587");

        props.put("mail.smtp.host", "smtp.yandex.ru");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        Session session = Session.getDefaultInstance(props);

        try {
            InternetAddress fromAddress = new InternetAddress(from);
            InternetAddress toAddress = new InternetAddress(to);

            // Create an Internet mail msg.
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(fromAddress);
            msg.setRecipient(Message.RecipientType.TO, toAddress);
            msg.setSubject(subject);
            msg.setSentDate(new Date());

            // Set the email msg text.
            MimeBodyPart messagePart = new MimeBodyPart();
            messagePart.setText(bodyText);

            // Set the email attachment file
            FileDataSource fileDataSource = new FileDataSource(attachmentName);

            MimeBodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.setDataHandler(new DataHandler(fileDataSource));
            attachmentPart.setFileName(fileDataSource.getName());

            // Create Multipart E-Mail.
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messagePart);
            multipart.addBodyPart(attachmentPart);

            msg.setContent(multipart);

            // Send the msg. Don't forget to set the username and password
            // to authenticate to the mail server.
            Transport.send(msg, "radplayer", "RadPlayer2020");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        System.out.println("Mail sended");
    }
}
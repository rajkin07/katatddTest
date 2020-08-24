package com.rajkin.kata;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Jmail {


    public static void main(String[] args) {
        // Recipient's email ID needs to be mentioned.
        String to = "Hlb-customer@apectraining.com";

        //String to = "rajeshbhai@datadotlabs.com";

        // Sender's email sID needs to be mentioned
        String from = "rajkinda786@gmail.com";
        String EMAIL_TO_CC = "rajeshbhai@datadotlabs.com";


        // Get system properties
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");


        // Get the default Session object.

        //Session session = Session.getDefaultInstance(props);rajkinda786@gmail.com

        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("rajkinda786@gmail.com", "Rajkin@123");
                    }
                });

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));


            // cc
            message.setRecipients(Message.RecipientType.CC,
                    InternetAddress.parse(EMAIL_TO_CC, true));

            // Set Subject: header field
            message.setSubject("This is the Subject Line!");

            // Now set the actual message
            message.setText("This is actual message");

            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}

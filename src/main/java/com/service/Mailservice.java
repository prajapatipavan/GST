package com.service;

import java.util.Properties;

import org.springframework.stereotype.Service;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class Mailservice {
	
	public void sendmessagemail(String email,String username,String Password) {
	  
	    Properties props = new Properties();
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.port", "465");
	    props.put("mail.smtp.ssl.enable", "true");
	    props.put("mail.smtp.auth", "true");

	    // Create a session with an authenticator
	    Session session = Session.getInstance(props, new Authenticator() {
	        protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication("ppavan.tec@gmail.com", "ijhywxirqjncugbh");
	        }
	    });

	    // Enable debug mode for session
	    session.setDebug(true);

	    try {
	        // Create a MimeMessage object
	        MimeMessage message = new MimeMessage(session);

	        // Set the recipient's email address
	        message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

	        // Set the subject of the email
	        message.setSubject("Welcome to  Gst Book Application  - Account Created");

	        
            message.setText("Dear"+username); 
	        
	        		
	        message.setText("We are pleased to inform you that an account has been created for you in the GST Transaction Portal.\n\n"
	                + "Below are your account details:\n\n"
	                + "Username:"+username + "\n"
	                + "Email: "+email + "\n"
	                + " Password: " +Password +"\n\n"
	                + "Please log in using the following link: http://localhost:9090/login\n\n"
	                + "For security purposes, we recommend you change your password upon logging in for the first time.\n\n"
	                + "Best regards,\n"
	                + "Admin Team\n"
	                + "GST Transaction Portal\n"
	                + "ppavan.tec@gmail.com");

	        // Send the message
	        Transport.send(message);

	        System.out.println("Message sent successfully");

	    } catch (MessagingException e) {
	        e.printStackTrace();
	    }
	}

}

package com.mail.gmail;

public interface GmailService {

    void sendEmail(String to, String message, String subject);
}

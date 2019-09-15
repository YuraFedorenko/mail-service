package com.mail;

import com.mail.gmail.GmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final GmailService gmailService;

    @GetMapping("/email")
    public void sendEmail(@RequestParam String to, @RequestParam String message, @RequestParam String subject){
        gmailService.sendEmail(to, message, subject);
    }
}

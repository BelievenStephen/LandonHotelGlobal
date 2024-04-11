package edu.wgu.d387_sample_code.controller;

import edu.wgu.d387_sample_code.Message;
import edu.wgu.d387_sample_code.service.EnglishWelcomeImpl;
import edu.wgu.d387_sample_code.service.FrenchWelcomeImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@CrossOrigin("http://localhost:4200")
public class WelcomeController {
    @GetMapping("/welcome")
    public String[] getWelcomeMessage() {

        EnglishWelcomeImpl englishWelcome = new EnglishWelcomeImpl();
        Thread englishThread = new Thread(englishWelcome);

        FrenchWelcomeImpl frenchWelcome = new FrenchWelcomeImpl();
        Thread frenchThread = new Thread(frenchWelcome);

        englishThread.start();
        frenchThread.start();

        try {
            englishThread.join();
            frenchThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }

        Message englishMessage = new Message(englishWelcome.getMessage());
        Message frenchMessage = new Message(frenchWelcome.getMessage());

        String[] message = new String[]{englishMessage.getGreeting(), frenchMessage.getGreeting()};

        return message;
    }
}

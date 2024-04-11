package edu.wgu.d387_sample_code.service;

import java.util.Locale;
import java.util.ResourceBundle;

public class FrenchWelcomeImpl implements Runnable {

    private String message;

    public String getMessage() {
        return message;
    }

    @Override
    public void run() {
        ResourceBundle bundle = ResourceBundle.getBundle("welcome", new Locale("fr", "CA"));
        this.message = bundle.getString("welcomeMessage");
    }
}

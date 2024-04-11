package edu.wgu.d387_sample_code.service;

import java.util.Locale;
import java.util.ResourceBundle;

public class EnglishWelcomeImpl implements Runnable {
    private String message;

    public String getMessage() {
        return message;
    }

    @Override
    public void run() {
        ResourceBundle bundle = ResourceBundle.getBundle("welcome", Locale.ENGLISH);
        this.message = bundle.getString("welcomeMessage");
    }
}
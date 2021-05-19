package com.example.mynavigation.Model;

public class HelpAndFeedback {

    private String helpText;
    private String emailText;
    private String phoneText;

    public HelpAndFeedback(String helpText, String emailText, String phoneText) {
        this.helpText = helpText;
        this.emailText = emailText;
        this.phoneText = phoneText;
    }

    public String getHelpText() {
        return helpText;
    }

    public void setHelpText(String helpText) {
        this.helpText = helpText;
    }

    public String getEmailText() {
        return emailText;
    }

    public void setEmailText(String emailText) {
        this.emailText = emailText;
    }

    public String getPhoneText() {
        return phoneText;
    }

    public void setPhoneText(String phoneText) {
        this.phoneText = phoneText;
    }
}

package com.raiden.learningunittest.chapter7;

public class Email {
    String email;
    String title;
    String body;

    public Email(String email, String title, String body) {
        this.email = email;
        this.title = title;
        this.body = body;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

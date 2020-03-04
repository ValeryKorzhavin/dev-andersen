package com.company;

public class ExternalMessageProvider implements MessageProvider {
    
    private String message = "Message from external message provider";

    public ExternalMessageProvider() {}

    public ExternalMessageProvider(String message) {
         this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

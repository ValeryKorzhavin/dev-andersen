package com.company;

public class DefaultMessageProvider implements MessageProvider {
	
    private String message = "Default message";

    public DefaultMessageProvider() {}

    public DefaultMessageProvider(String message) {
         this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

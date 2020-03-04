package com.company;

public class PrintService {

    private MessageProvider messageProvider;
    
    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    public void printMessage() {
        System.out.println(messageProvider.getMessage());
    }

}

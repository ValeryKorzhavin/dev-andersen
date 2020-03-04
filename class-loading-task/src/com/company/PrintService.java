package com.company;

import java.util.logging.Logger;

public class PrintService {

    private MessageProvider messageProvider;

    private static final Logger LOGGER = Logger.getLogger(PrintService.class.getName());  
    
    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    public void printMessage() {
        LOGGER.info(messageProvider.getMessage());
    }

}

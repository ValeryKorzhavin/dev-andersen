package com.company;

import java.lang.reflect.InvocationTargetException;

public class Main {

    @SuppressWarnings(value = "unchecked")
    public static void main(String[] args) throws NoSuchMethodException, 
        InvocationTargetException, InstantiationException, 
        IllegalAccessException, ClassNotFoundException {

        PrintService service = new PrintService();
        service.setMessageProvider(new DefaultMessageProvider());
        service.printMessage();

        Class klass = new CustomClassLoader()
            .findClass("com.company.ExternalMessageProvider");
        
        MessageProvider messageProvider = (MessageProvider) klass
            .getDeclaredConstructor()
            .newInstance();

        service.setMessageProvider(messageProvider);
        service.printMessage();
    }

}

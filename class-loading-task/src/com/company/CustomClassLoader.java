package com.company;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.File;

public class CustomClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] b = loadClassFromFile(name);
        return defineClass(name, b, 0, b.length);
    }

    private byte[] loadClassFromFile(String fileName) {
        InputStream inputStream = getClass()
            .getClassLoader()
            .getResourceAsStream(fileName.replace('.', File.separatorChar) + ".class");
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();

        byte[] buffer;
        int bytes = 0;
        try (InputStream is = inputStream; ByteArrayOutputStream os = byteStream;) {
            while ((bytes = is.read()) != -1) {
                os.write(bytes);
            }
            return os.toByteArray();
        } catch (IOException ioex) {
            throw new RuntimeException(ioex.getMessage(), ioex);
        }           
    }

}

package com.jike.java.jvm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HelloClassLoader extends ClassLoader {

    public static void main(String[] args) {
        try {
            Class<?> helloClass = new HelloClassLoader().findClass("Hello");
            Object helloInstance = helloClass.newInstance();
            Method method = helloClass.getMethod("hello");
            method.invoke(helloInstance);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        File file = new File(this.getClass().getResource("").getPath() + "Hello.xlass");
        long fileSize = file.length();

        byte[] bytes = new byte[(int) fileSize];

        try {
            new FileInputStream(file).read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) ((byte) 255 - bytes[i]);
        }

        return defineClass(name, bytes, 0, bytes.length);
    }
}

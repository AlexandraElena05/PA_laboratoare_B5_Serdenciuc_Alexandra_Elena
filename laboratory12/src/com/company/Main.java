package com.company;

import com.company.example.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.net.MalformedURLException;
import java.net.URLClassLoader;
import java.net.URL;
import java.io.File;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        String location = null;
        String name = null;
        try {
            System.out.println("Enter file location use  \\\\ between directories");
            location = reader.readLine();
            System.out.println("Enter class name");
            name = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println( "Reading " +name+ " located at:  " + location);


        //File file = new File("c:\\facultate\\Anul 2, sem 2\\PA\\laboratory12\\classes\\"); used for local testing
        File file = new File(location);

        try {
            URL url = file.toURI().toURL();
            URL[] urls = new URL[]{url};
            ClassLoader cl = new URLClassLoader(urls);
            //Class cls = cl.loadClass("com.company.example.MyProgram"); used for lcoal testing
            Class cls = cl.loadClass(name);

            int passed = 0, failed = 0;

            for (Method m : cls.getMethods()) {
                if (m.isAnnotationPresent(Test.class)) {
                    try {
                        m.invoke(null);
                        passed++;
                    } catch (Throwable ex) {
                        System.out.printf("Test %s failed: %s %n", m, ex.getCause());
                        failed++;
                    }
                    System.out.printf("Passed: %d, Failed %d%n", passed, failed);
                }
            }
            String result = "";
            // show all of the class' methods
            Method[] methods = cls.getDeclaredMethods();
            if (methods.length > 0) {
                int i = 0;
                for (Method method : methods) {
                    if (method.getName() != null) {
                        i++;
                        result += i + " " + method.getName() + "\n";
                    }
                }
            }
            System.out.println(result);
            //show package for class
            System.out.println("Package for class is:" + cls.getPackageName());

        } catch (MalformedURLException e) {
        } catch (ClassNotFoundException e) {
        }

        }

}

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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {

        var c = findClasses("C:\\facultate\\Anul 2, sem 2\\PA\\laboratory12\\out\\production\\laboratory12", "");
       
        for (Class cls : c
        ) {
            int passed = 0, failed = 0;

            for (Method m : cls.getMethods()) {
                if (m.isAnnotationPresent(Test.class) && Modifier.isPublic(m.getModifiers())) {
                    try {
                        if(!Modifier.isStatic(m.getModifiers())){
                           var mConstructor = cls.getConstructor();
                           var method = mConstructor.newInstance();
                           Object[] methodArgs = new Object[]{};
                           var types =m.getParameterTypes();
                            for (Class type:types
                                 ) {
                                if(type == String.class)
                                   methodArgs = appendValue(methodArgs, "String");
                                if(type == Integer.class)
                                    methodArgs = appendValue(methodArgs, 2);
                            }
                           m.invoke(method, methodArgs);
                        }else
                        {
                            m.invoke(null);
                        }
                        passed++;
                    } catch (Throwable ex) {
                        System.out.printf("Test %s failed: %s %n", m, ex.getCause());
                        failed++;
                    }
                    System.out.printf("Passed: %d, Failed %d%n", passed, failed);
                }
            }
            String result = "\n\n";
            // show all of the class' methods
            Method[] methods = cls.getDeclaredMethods();
            result += cls + "\n";
            if (methods.length > 0) {
                for (Method method : methods) {
                    if (method.getName() != null) {
                        result += Modifier.toString(method.getModifiers()) + " ";
                        result += method.getReturnType().getName()+ " " + method.getName() + "( ";
                        var types =method.getParameterTypes();
                        for (Class type:types
                        ) {
                            result += type + ", ";
                        }
                        result += "); \n";
                    }
                }
            }
            System.out.println(result);
            //show package for class
            System.out.println("Package for class" + cls.getName() + " is:" + cls.getPackageName());
        }

    }
    public static List<Class> findClasses(String path, String packageName){
        List<Class> classes = new ArrayList<>();

        try {
            if (path.startsWith("file:")) {

                URL jar = new URL(path);
                ZipInputStream zip = new ZipInputStream(jar.openStream());
                ZipEntry entry;
                while ((entry = zip.getNextEntry()) != null) {
                    if (entry.getName().endsWith(".class")) {
                        String className = entry.getName()
                                .replaceAll("[$].*", "")
                                .replaceAll("[.]class", "")
                                .replace('/', '.');
                        if (className.startsWith(packageName)) {
                            classes.add(Class.forName(className));
                        }
                    }
                }
            }
            File dir = new File(path);
            if (!dir.exists()) {
                return classes;
            }
            File[] files = dir.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    if (packageName == ""){
                        classes.addAll(findClasses(file.getAbsolutePath(),
                                packageName + file.getName()));
                    }
                    classes.addAll(findClasses(file.getAbsolutePath(),
                            packageName + "." + file.getName()));
                } else if (file.getName().endsWith(".class")) {
                    String className = packageName
                            + '.'
                            + file.getName().substring(0,
                            file.getName().length() - 6);
                    classes.add(Class.forName(className));
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
        }


        return classes;

    }

    private static Object[] appendValue(Object[] obj, Object newObj) {

        ArrayList<Object> temp = new ArrayList<Object>(Arrays.asList(obj));
        temp.add(newObj);
        return temp.toArray();

    }
}

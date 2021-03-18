package com.company;

import java.awt.*;
import java.io.*;

public class CatalogUtil {
    public static void save(Catalog catalog)
            {
        try (var oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    public static Catalog load(String path) throws InvalidCatalogException {
        try {
            FileInputStream fin = new FileInputStream(path);
            ObjectInputStream oin = new ObjectInputStream(fin);
            Catalog catalog = (Catalog) oin.readObject();
            oin.close();
            fin.close();
            return catalog;
            }
        catch (IOException | ClassNotFoundException e){
            System.out.println(e);
            throw new InvalidCatalogException(e);
        }
    }

    public static void play(Item item)
    {
        try{
            if(!Desktop.isDesktopSupported()){
                System.out.println("Desktop is not supported");
            }
            Desktop desktop = Desktop.getDesktop();
            File file = new File(item.getLocation());
            if(file.exists()){
                desktop.open(file);
            }
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
    }
}

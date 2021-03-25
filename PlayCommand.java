package com.company;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlayCommand extends Command{

    public PlayCommand(Catalog catalog) {
        super(catalog);
    }

    @Override
    public void Execute() {
        Item item;
        catalog.list();
        System.out.println("Type item ID");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            String Id = reader.readLine();
            item = catalog.findById(Id);
            if(item != null){
                if(!Desktop.isDesktopSupported()){
                    System.out.println("Desktop is not supported");
                }
                Desktop desktop = Desktop.getDesktop();
                File file = new File(item.getLocation());
                if(file.exists()){
                    desktop.open(file);
                }
            }
            else
            {
                System.out.println("Invalid ID");
            }
        }
        catch (IOException e)
        {
            System.out.println(e);
        }

    }
}

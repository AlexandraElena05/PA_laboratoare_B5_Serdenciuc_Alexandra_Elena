package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AddCommand extends Command{

    public AddCommand(Catalog catalog) {
        super(catalog);
    }

    @Override
    public void Execute() {
        Item newItem;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1:melodie noua, 2:carte noua");
        try {
            String number = reader.readLine();
            if(number.equals("1"))
            {
                System.out.println("nume artist:");
                String artistName = reader.readLine();
                System.out.println("nume album:");
                String albumName = reader.readLine();
                System.out.println("nume melodie:");
                String melodieName = reader.readLine();
                System.out.println("nume cale:");
                String caleName = reader.readLine();
                newItem = new Song(artistName, albumName, melodieName, caleName );
            }
            else if(number.equals("2"))
            {
                newItem = new Book("bestAutor", "bestEditura", "bestBook", "d:/java/book.pdf" );
            }
            else
            {
                throw new Exception("Select a number between 1 and 2");
            }
            catalog.add(newItem);
            System.out.println("Item adaugat cu succes");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

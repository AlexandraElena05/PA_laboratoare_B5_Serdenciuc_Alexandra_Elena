package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoadCommand extends Command{

    public LoadCommand(Catalog catalog) {
        super(catalog);
    }

    @Override
    public void Execute() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Give path to Catalog");
        try {
            String path = reader.readLine();
            catalog = CatalogUtil.load(path);
        }
        catch (IOException | InvalidCatalogException e) {
            System.out.println(e);
        }

    }
}

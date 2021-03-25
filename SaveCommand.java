package com.company;

import java.io.IOException;

public class SaveCommand extends Command{

    public SaveCommand(Catalog catalog) {
        super(catalog);
    }

    @Override
    public void Execute() {
        CatalogUtil.save(catalog);
        System.out.println("Catalog saved at path " + catalog.getPath());
    }
}

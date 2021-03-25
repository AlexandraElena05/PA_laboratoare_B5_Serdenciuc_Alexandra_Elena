package com.company;

public class ListCommand extends Command{

    public ListCommand(Catalog catalog) {
        super(catalog);
    }

    @Override
    public void Execute() {
        catalog.list();
    }
}


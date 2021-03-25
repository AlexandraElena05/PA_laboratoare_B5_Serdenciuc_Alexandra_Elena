package com.company;

public abstract class Command {
    protected Catalog catalog;

    public Command(Catalog catalog) {
        this.catalog = catalog;
    }

    public abstract void Execute();
}

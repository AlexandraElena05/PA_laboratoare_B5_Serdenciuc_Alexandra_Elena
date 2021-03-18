package com.company;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Catalog implements Serializable {
    private String name;
    private String path;
    private List<Item> items = new ArrayList<>();

    public Catalog(String name, String  path) {
        this.name = name;
        this.path = path;
    }

    //…
    public void add(Item item) {
        items.add(item);
    }

    public void list(){
        System.out.println(Arrays.toString(items.toArray()));
    }

    public Item findById(String id) {
        //…
        return items.stream()
                .filter(d -> d.getId().equals(id)).findFirst().orElse(null);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}

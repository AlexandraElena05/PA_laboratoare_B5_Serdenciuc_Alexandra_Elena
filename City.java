package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class City {
    private List<Location> nodes = new ArrayList<>();

    public City(List<Location> nodes) {
        this.nodes = nodes;
    }

    public City() {
    }

    public List<Location> freeLocation(){
        var free = new ArrayList<Location>();
        for (Location location:nodes
             ) {
            if(location instanceof Visitable && !(location instanceof Payable))
                free.add(location);

        }
        //sort by openingHour
        return free;


    };


    public List<Location> getNodes() {
        return nodes;
    }

    public void setNodes(List<Location> nodes) {
        this.nodes = nodes;
    }

    //… constructors, getters, setters


    public void addLocation(Location node) {
        nodes.add(node);
    }

    //… toString, etc.

    @Override
    public String toString() {
        return "City{" +
                "nodes=" + nodes +
                '}';
    }
}

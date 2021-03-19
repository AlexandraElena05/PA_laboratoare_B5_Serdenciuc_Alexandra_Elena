package com.company;

public class School implements Comparable<School> {
    private String name;
    private Integer capacity;

    public Integer getCapacity() {
        return capacity;
    }

    //
    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public School(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(School o) {
        return this.name.compareTo(o.getName());
    }
}

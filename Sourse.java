package com.company;

import java.util.Objects;

public abstract class Sourse extends Object {
    String name;
    int commodities;

    public Sourse(String name, int commodities) {
        this.name = name;
        this.commodities = commodities;
    }

    public int getCommodities() {
        return commodities;
    }

    public void setCommodities(int commodities) {
        this.commodities = commodities;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return name;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sourse)) return false;
        Sourse sourse = (Sourse) o;
        return getName().equals(sourse.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}

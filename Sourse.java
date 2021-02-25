package com.company;

public class Sourse {
    String name;
    SourseType type;

    public Sourse(String name, SourseType type){
        this.name = name;
        this.type = type;
    }

    public Sourse() {
        name = null;
    }

    public SourseType getType() {
        return type;
    }

    public void setType(SourseType type) {
        this.type = type;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        //return super.toString();
        return "Sourse{" +
                "name" + name + '\'' +
                ", type= " + type +
                '}';
    }
}

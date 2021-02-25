package com.company;

public class Destination {
    String name;

    public Destination(String name){
        this.name = name;
    }

    public Destination(){
       name = null;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
        public String toString() {
            //return super.toString();
            return " Destination{" +
            "name= " +name + '\'' +
            "}";
        }
}



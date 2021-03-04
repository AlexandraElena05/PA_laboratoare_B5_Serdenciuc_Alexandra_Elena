package com.company;

import java.time.LocalTime;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Hotel v1 =   new Hotel();
        v1.setName("Hotel");
        Museum v2 = new Museum();
        v2.setName("Museum A");
        Museum v3 = new Museum();
        v3.setName("Museum B");
        //m.setOpeningTime(LocalTime.of(9, 30)); //9:30
        //m.setClosingTime(LocalTime.parse("17:00"));
        //m.setTicketPrice(20);
        Church v4 = new Church();
        v4.setName("Church A");
        Church v5 = new Church();
        v5.setName("Church B");
        Restaurant v6 = new Restaurant();
        v6.setName("Restaurant");

        v1.setCost(v2, 10);
        v1.setCost(v3, 50);

        v2.setCost(v3, 20);
        v2.setCost(v4, 20);
        v2.setCost(v5, 10);

        v3.setCost(v4, 20);

        v4.setCost(v5, 30);
        v4.setCost(v6, 10);

        v5.setCost(v6, 20);

        City city =  new City();
        city.addLocation(v1);
        city.addLocation(v2);
        city.addLocation(v3);
        city.addLocation(v4);
        city.addLocation(v5);
        city.addLocation(v6);

        System.out.println(city.toString());
    }
}

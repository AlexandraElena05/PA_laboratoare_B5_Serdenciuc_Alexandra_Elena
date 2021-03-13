package com.company;

import java.util.Map;

public class TravelPlan {
    private City city;
    private Map<Location, Integer> preferences;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Map<Location, Integer> getPreferences() {
        return preferences;
    }

    public void setPreferences(Map<Location, Integer> preferences) {
        this.preferences = preferences;
    }
}

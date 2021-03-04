package com.company;

import java.time.LocalTime;
import java.util.Map;

public class Hotel extends Location implements Visitable, Payable {
    private LocalTime openingTime, closingTime;
    private double ticketPrice;

    public Hotel() {
    }

    public Hotel(String name, Map<Location, Integer> cost) {
        super(name, cost);
    }

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    @Override
    public void setOpeningTime() {

    }

    @Override
    public void setClosingTime() {

    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}

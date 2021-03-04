package com.company;

import java.time.LocalTime;
import java.util.Map;

public class Museum extends Location implements Visitable, Payable{
    private LocalTime openingTime, closingTime;
    private double ticketPrice;

    public Museum(String name, Map<Location, Integer> cost) {
        super(name, cost);
    }

    public Museum() {
        super();
    }

    @Override
    public LocalTime getOpeningTime() {
        return openingTime;
    }

    @Override
    public LocalTime getClosingTime() {
        return closingTime;
    }

    @Override
    public void setOpeningTime() {

    }

    @Override
    public void setClosingTime() {

    }

    @Override
    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}

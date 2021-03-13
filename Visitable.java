package com.company;

import java.time.Duration;
import java.time.LocalTime;

public interface Visitable {
    default LocalTime getOpeningTime(){
        return LocalTime.of(9, 30, 0,0);
    };
    default LocalTime getClosingTime(){
        return LocalTime.of(20, 0, 0, 0);
    };

    void setOpeningTime();
    void setClosingTime();
    static Duration getVisitingDuration(LocalTime open, LocalTime close){

        return Duration.between(open, close);
    };
}

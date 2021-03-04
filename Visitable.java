package com.company;

import java.time.LocalTime;

public interface Visitable {
    LocalTime getOpeningTime();
    LocalTime getClosingTime();

    void setOpeningTime();
    void setClosingTime();

}

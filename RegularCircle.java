package com.company;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class RegularCircle extends Ellipse2D.Double{
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    private Color color;

    public RegularCircle(double x, double y, double w, Color color) {
        super(x, y, w, w);
        this.color = color;
    }
}

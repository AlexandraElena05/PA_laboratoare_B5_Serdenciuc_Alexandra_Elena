package com.company;

import javax.swing.*;
import java.awt.*;

public class ConfigPanel extends JPanel{
    final MainFrame frame;
    JLabel sidesLabel; // we’re drawing regular polygons
    JSpinner sidesField; // number of sides
    JComboBox colorCombo; // the color of the shape

    public String getColor(){
        return colorCombo.getSelectedItem().toString();
    }

    public Integer getSides(){
        return (Integer) sidesField.getValue();
    }

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //create the label and the spinner
        sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6); //default number of sides
        String Colors[]={"Random", "Blue", "Red", "Black", "Gray", "Yellow", "Green", "Cyan"};
        colorCombo = new JComboBox(Colors);
        this.setLayout(new FlowLayout());
        this.add(sidesLabel); //JPanel uses FlowLayout by default
        this.add(sidesField);
        this.add(colorCombo);
    }

}

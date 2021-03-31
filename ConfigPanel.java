package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ConfigPanel extends JPanel{
    final MainFrame frame;
    JLabel sidesLabel; // we’re drawing regular polygons
    JSpinner sidesField; // number of sides
    JComboBox colorCombo; // the color of the shape
    JComboBox shapeCombo;

    public String getShape(){
        return shapeCombo.getSelectedItem().toString();
    }

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
        String Shapes[]={"polygon", "circle"};
        shapeCombo = new JComboBox(Shapes);
        colorCombo = new JComboBox(Colors);
        shapeCombo.addActionListener(this::showSides);
        this.setLayout(new FlowLayout());
        this.add(sidesLabel); //JPanel uses FlowLayout by default
        this.add(sidesField);
        this.add(colorCombo);
        this.add(shapeCombo);
    }
     private void showSides(ActionEvent e){
        if(this.getShape() == "polygon"){
            this.sidesField.setVisible(true);
            this.sidesLabel.setVisible(true);
        }
        else
        {
            this.sidesField.setVisible(false);
            this.sidesLabel.setVisible(false);
        }
     }

}

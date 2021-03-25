package com.company;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private ConfigPanel configPanel;
    private ControlPanel controlPanel;
    private DrawingPanel canvas;

    public ConfigPanel getConfigPanel() {
        return configPanel;
    }

    public ControlPanel getControlPanel() {
        return controlPanel;
    }

    public DrawingPanel getCanvas() {
        return canvas;
    }

    public MainFrame() {
        super("My Drawing Application");
        configPanel=new ConfigPanel(this);
        canvas =new DrawingPanel(this);
        controlPanel=new ControlPanel(this);
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create the components
        this.setSize(600, 600);
        this.add(configPanel, BorderLayout.NORTH);
        this.add(canvas, BorderLayout.CENTER);
        this.add(controlPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }
}

package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    JFileChooser fc = new JFileChooser();

    public ControlPanel(MainFrame frame) {
        this.frame = frame; init();
    }
    private void init() {
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        setLayout(new GridLayout(1, 4));

        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
        this.add(saveBtn);
        this.add(loadBtn);
        this.add(resetBtn);
        this.add(exitBtn);
    }
    private void reset(ActionEvent e){
        frame.getCanvas().resetAll();
    }
    private void load(ActionEvent e){
        try {
            int returnVal = fc.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION)
                {
                    File file = fc.getSelectedFile();
                    BufferedImage image = ImageIO.read(file);
                    this.frame.getCanvas().loadFile(image);
                }
            } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    private void exit(ActionEvent e){
        System.exit(0);
    }
    private void save(ActionEvent e) {
        try {
            int returnVal = fc.showSaveDialog(this);
            if(returnVal == JFileChooser.APPROVE_OPTION)
            {
                File file = fc.getSelectedFile();
                ImageIO.write(frame.getCanvas().image, "PNG", file);
            }
        } catch (IOException ex) { System.err.println(ex); }
    }

}

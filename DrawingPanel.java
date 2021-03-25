package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DrawingPanel extends JPanel{
    final MainFrame frame;
    final static int W = 600, H = 600;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the "tools" needed to draw in the image

    public DrawingPanel(MainFrame frame) {
        this.frame = frame; createOffscreenImage(); init();
    }

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE); //fill the image with white
        graphics.fillRect(0, 0, W, H);
    }

    private void init() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY()); repaint();
            } //Can’t use lambdas, JavaFX does a better job in these cases
        });
    }

    public void setPreferredSize(Dimension dimension) {
    }

    private void drawShape(int x, int y) {
        Random rand = new Random();
        int radius = rand.nextInt(60); //generate a random number
        int sides = this.frame.getConfigPanel().getSides(); //get the value from UI (in ConfigPanel)
        Color color = transformColor(this.frame.getConfigPanel().getColor()); //create a transparent random Color.
        graphics.setColor(color);
        graphics.fill(new RegularPolygon(x, y, radius, sides));
    }

    public void resetAll(){
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
        repaint();
    }

    public void loadFile(BufferedImage image){
        graphics.drawImage(image, 0, 0, null);
        repaint();
    }

    public Color transformColor(String color)
    {
        Map<String, Color> colorMap = new HashMap<>();
        colorMap.put("Blue",Color.blue);
        colorMap.put("Red",Color.red);
        colorMap.put("Green",Color.green);
        colorMap.put("Yellow",Color.yellow);
        colorMap.put("Black",Color.black);
        colorMap.put("Gray",Color.gray);
        colorMap.put("Cyan",Color.cyan);
        for(String it:colorMap.keySet())
        {
            if(it==color)
                return colorMap.get(it);
        }
        Random defaultColor=new Random();
        return new Color(defaultColor.nextInt(0xFFFFFF));

    }
    @Override
    public void update(Graphics g) { }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }


}

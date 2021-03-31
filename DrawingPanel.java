package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class DrawingPanel extends JPanel{
    final MainFrame frame;
    final static int W = 600, H = 600;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the "tools" needed to draw in the image
    private Boolean clearMode = false;
    private Boolean freeMode = false;
    private java.util.List<RegularPolygon> shapes = new ArrayList<>();
    private java.util.List<RegularCircle> circles = new ArrayList<>();

    public Boolean getFreeMode() {
        return freeMode;
    }

    public void setFreeMode(Boolean freeMode) {
        this.freeMode = freeMode;
    }

    public Boolean getClearMode() {
        return clearMode;
    }

    public void setClearMode(Boolean clearMode) {
        this.clearMode = clearMode;
    }

    public DrawingPanel(MainFrame frame) {
        this.frame = frame; createOffscreenImage(); init();
    }

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE); //fill the image with white
        graphics.fillRect(0, 0, W, H);
    }

    private List<Point> pointList = new ArrayList<>();

    private void init() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (!clearMode && !freeMode) {
                    drawShape(e.getX(), e.getY());
                    repaint();
                } else
                {
                    deleteShape(e.getX(), e.getY());
                    repaint();
                }
            }
            @Override
            public void mouseReleased(MouseEvent e){
                if(!clearMode && freeMode){
                    drawFreeShape();
                    repaint();
                }
            }
        });

        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (!clearMode && freeMode) {
                    pointList.add(e.getPoint());
                }
            }
        });

    }

    private void drawFreeShape(){
        Color color = transformColor(this.frame.getConfigPanel().getColor()); //create a transparent random Color.
        graphics.setColor(color);
        for(Point p : pointList){
            System.out.println(p);
            graphics.drawRect(p.x, p.y, 1, 1);
            //pointList.remove(p);
        }
        pointList.removeAll(pointList);
    }

    public void setPreferredSize(Dimension dimension) {
    }

    private void drawShape(int x, int y) {
        Random rand = new Random();
        int radius = rand.nextInt(60); //generate a random number
        int sides = this.frame.getConfigPanel().getSides(); //get the value from UI (in ConfigPanel)
        Color color = transformColor(this.frame.getConfigPanel().getColor()); //create a transparent random Color.
        graphics.setColor(color);
        if(this.frame.getConfigPanel().getShape() == "polygon"){
            var shape = new RegularPolygon(x, y, radius, sides);
            shape.setColor(color);
            shapes.add(shape);
            graphics.fill(shape);
        }
        else {
            var circle = new RegularCircle(x, y, radius, color);
            circles.add(circle);
            graphics.fill(circle);
        }
    }

    private void deleteShape(int x, int y){
        if(this.frame.getConfigPanel().getShape() == "polygon") {
            for (Polygon n : shapes) {
                if (n.contains(x, y)) {
                    image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
                    graphics = image.createGraphics();
                    graphics.setColor(Color.WHITE);
                    graphics.fillRect(0, 0, W, H);
                    repaint();
                    shapes.remove(n);
                    redoShapes();
                    break;
                }
            }
        }
        else
        {
            for (Ellipse2D.Double n : circles) {
                if (n.contains(x, y)) {
                    image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
                    graphics = image.createGraphics();
                    graphics.setColor(Color.WHITE);
                    graphics.fillRect(0, 0, W, H);
                    repaint();
                    circles.remove(n);
                    redoShapes();
                    break;
                }
            }
        }
    }

    private void redoShapes(){
        for(RegularPolygon n : shapes){
            graphics.setColor(n.getColor());
            graphics.fill(n);
        }
        for(RegularCircle n : circles){
            graphics.setColor(n.getColor());
            graphics.fill(n);
        }
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

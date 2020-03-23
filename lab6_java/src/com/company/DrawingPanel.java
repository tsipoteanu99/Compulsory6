package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
/**
 * Am generat numere random pentru nuantele de rosu(r), galben(g), albastru(b) si pentru intensitatea transparentei
 * Cu numerele generate am format o culoare random, care se schimba la fiecare forma desenata
 * Am verificat setarile din config panel cu un if, daca colorCombo e setat pe random se vor genera forme cu rgb-ul de mai sus, daca e setat pe Black se vor genera forme negre
 * **/

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800 , H = 600;


    BufferedImage image; //the offscreen image
    Graphics2D graphics;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
    }

    private void createOffscreenImage(){
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);  //fill the image with white
        graphics.fillRect(0,0,W,H);
    }

    private void init() {


        setPreferredSize(new Dimension(W, H)); //don't use setSize. Why?
                                                // Pentru ca daca folosim setSize, fereastra va fi mica si va trebui maximizata

        setBorder(BorderFactory.createEtchedBorder());

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
                repaint();
            }
        });
    }

    private void drawShape(int x, int y){
        Random rand=new Random();

        int radius = rand.nextInt(50)+50; //...TODO
        int sides= (int) frame.configPanel.sidesField.getValue(); //...TODO

        int r = rand.nextInt(255);
        int g = rand.nextInt(255);
        int b = rand.nextInt(255);
        int transp = rand.nextInt(255);
        Color color= new Color(r, g, b,transp); //TODO
        if (!frame.configPanel.colorCombo.getSelectedItem().equals("Random")) {
            graphics.setColor(Color.BLACK);
            graphics.fill(new RegularPolygon(x, y, radius, sides));
        } else {
            graphics.setColor(color);
            graphics.fill(new RegularPolygon(x, y, radius, sides));
        }

    }
    @Override
    public void update(Graphics g){ }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}

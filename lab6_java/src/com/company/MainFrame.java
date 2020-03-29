package com.company;

import com.sun.deploy.panel.ControlPanel;

import javax.swing.*;

import java.awt.*;

import static javax.swing.SwingConstants.*;
/**
 * Am instantiat cate un obiect din fiecare clasa, pentru controlPanel am dat calea prin pachet deoarece probabil mai este un ControlPanel deja definit si nu ma lasa sa accesez constructorul creat de mine
 * Am asezat fiecare component dupa cum s-a cerut in cerinte
 * **/

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    com.company.ControlPanel controlPanel;
    DrawingPanel canvas;
    ShapesPanel shapesPanel;

    public MainFrame(){
        super("My drawing app");
        init();
    }

    private void init() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //create the components
        canvas = new DrawingPanel(this);
        configPanel = new ConfigPanel(this);
        controlPanel = new com.company.ControlPanel(this);
        shapesPanel = new ShapesPanel(this);

        //aranjare componente in frame
        //JFrame uses a BorderLayout by default
        add(canvas, CENTER);
        add(shapesPanel, BorderLayout.WEST);
        add(configPanel, BorderLayout.NORTH);
        add(controlPanel,BorderLayout.SOUTH);

        //invoke the layout manageer
        pack();
    }
}

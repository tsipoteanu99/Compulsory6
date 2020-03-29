package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static com.company.DrawingPanel.H;
import static com.company.DrawingPanel.W;

/**
 * Am adaugat butoanele de save, load, reset, exit
 * Am setat functionalitatilor butoanelor, prin functiile create ulterior
 * In load am reconstruit BufferedImage-ul cu ajutorul noii imagini luata de la calea data si am actualizat Graphics2D-ul.
 *     --->> OPTIONAL UPDATE: Am inlocuit calea standard pentru SAVE si LOAD din director cu o cale aleasa cu ajutorul JFileChooser. <<---
 * In reset pur si simplu am creat un nou Offscreen.
 * **/

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("save");
    JButton loadBtn = new JButton("load");
    JButton resetBtn = new JButton("reset");
    JButton exitBtn = new JButton("exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setLayout(new GridLayout(1, 4)); // butoanele vor fi asezate pe un rand si 4 coloane
        //add all buttons
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);

        //setam functionalitatile butoanelor

        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
    }

    private void save(ActionEvent e) {



        try {
            JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            int returnValue = jfc.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION){
                File selectedFile = jfc.getSelectedFile();
            ImageIO.write(frame.canvas.image, "PNG", new File(selectedFile.getAbsolutePath()));
            }
        } catch (
                IOException ex) {
            System.err.println(ex);
        }
    }

    private void load(ActionEvent e) {
        try {JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            int returnValue = jfc.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = jfc.getSelectedFile();
                File loadedImage = new File(selectedFile.getAbsolutePath());
                 frame.canvas.image = ImageIO.read(loadedImage);
                 frame.canvas.graphics = frame.canvas.image.createGraphics();
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
        repaint();
    }

    private void reset(ActionEvent e){
        frame.canvas.image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        frame.canvas.graphics = frame.canvas.image.createGraphics();
        frame.canvas.graphics.setColor(Color.WHITE);
        frame.canvas.graphics.fillRect(0,0,W,H);
    }

    private void exit(ActionEvent e){
        System.exit(3);
    }
}


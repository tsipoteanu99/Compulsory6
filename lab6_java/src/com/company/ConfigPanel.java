package com.company;

import javax.swing.*;
/**
 * Aici am creat labelul pentru sides si un spinner pentru a seta numarul lor
 * colorCombo va lua valori dintr-un String[] cu valorile Random si Black si ne va ajuta la selectarea culorii formelor
 * **/
public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel sidesLabel;
    JSpinner sidesField;
    JComboBox<String> colorCombo;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init(){
        //create the label and the spinner
        sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(1,0,100,1));
        sidesField.setValue(6);  //default number of sides

        //create colorCombo containing Random and Black
        String[] color={"Random", "Black"};
        colorCombo=new JComboBox<>(color);

        add(sidesLabel);
        add(sidesField);
        add(colorCombo);
    }
}

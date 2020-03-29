package com.company;

import javax.swing.*;
/**
 * Aici am creat o noua clasa pentru un nou panu de control, in care voi da forma pe care vreau sa o desenez, in cazul de fata Arc sau Ellipse. Daca selectez none, va desena un RegularPoligon folosind
 * informatiile din ConfigPanel.
 * **/
public class ShapesPanel extends JPanel {
    private final MainFrame frame;
    JComboBox<String> shapes;

    public ShapesPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init(){
        String[] shapeName={"None", "Arc", "Ellipse", };
        shapes=new JComboBox<>(shapeName);
        add(shapes);
    }
}

package com.michielswaanen.view;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;

public class CalculatorScreenView extends AbstractView {

    private JLabel screen;

    public CalculatorScreenView() {
        this.screen = new JLabel();
        this.screen.setPreferredSize(new Dimension(0, 50));
        this.screen.setFont(new Font("Arial", Font.PLAIN, 20));
    }

    /**
     * @see IView#getGUI()
     */
    @Override
    public JComponent getGUI() {
        return this.screen;
    }

    /**
     * Updates the equation on calculator screen (JLabel (member variable)) when triggered
     * Currently triggered when a (number or symbol) key is pressed in the application
     *
     * @param o   Observable class that the call (trigger came from)
     * @param arg An object specified in the notifyObserver, contains the new state.
     */
    @Override
    public void update(Observable o, Object arg) {
        this.screen.setText(((String) arg));
    }
}

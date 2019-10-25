package com.michielswaanen.view;

import com.michielswaanen.controller.CalculatorController;
import com.michielswaanen.controller.IController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class CalculatorKeyboardView extends AbstractView {

    private JPanel keyPanel;
    private List<JButton> numberKeys;
    private JButton additionSymbolKey;
    private JButton multiplicationSymbolKey;
    private JButton divisionSymbolKey;
    private JButton subtractionSymbolKey;
    private JButton resultSymbolKey;

    public CalculatorKeyboardView(IController controller) {
        super(controller);
        initNumberKeys();
        initSymbolKeys();
        initKeyPanel();
    }

    /**
     * Initialize all the number keys and set the action when they are pressed
     */
    private void initNumberKeys() {
        this.numberKeys = new ArrayList<>();
        for(int i = 1; i < 10; ++i) {
            JButton key = new JButton();
            key.setText(i + "");
            key.addActionListener((e) -> {
                ((CalculatorController) getController()).onKeyPress(
                        ((JButton) e.getSource()).getText());
            });
            this.numberKeys.add(key);
        }
    }

    /**
     * Initialize all the symbol keys and set the action when they are pressed
     */
    private void initSymbolKeys() {
        this.additionSymbolKey = new JButton("+");
        this.additionSymbolKey.addActionListener((e) -> {
            ((CalculatorController) getController()).onKeyPress("+");
        });
        this.multiplicationSymbolKey = new JButton("*");
        this.multiplicationSymbolKey.addActionListener((e) -> {
            ((CalculatorController) getController()).onKeyPress("*");
        });
        this.divisionSymbolKey = new JButton("/");
        this.divisionSymbolKey.addActionListener((e) -> {
            ((CalculatorController) getController()).onKeyPress("/");
        });
        this.subtractionSymbolKey = new JButton("-");
        this.subtractionSymbolKey.addActionListener((e) -> {
            ((CalculatorController) getController()).onKeyPress("-");
        });
        this.resultSymbolKey = new JButton("=");
        this.resultSymbolKey.addActionListener((e) -> {
            ((CalculatorController) getController()).onCalculate();
        });
    }

    /**
     * Add all the individually initialized modules to a panel
     *
     * @pre All the objects must be initialized using the {@link #initSymbolKeys()} and {@link #initNumberKeys()}
     */
    private void initKeyPanel() {
        this.keyPanel = new JPanel();
        this.keyPanel.setLayout(new GridLayout(4, 4));

        this.numberKeys.forEach((numberKey -> {
            this.keyPanel.add(numberKey);
        }));

        this.keyPanel.add(this.additionSymbolKey);
        this.keyPanel.add(this.multiplicationSymbolKey);
        this.keyPanel.add(this.divisionSymbolKey);
        this.keyPanel.add(this.subtractionSymbolKey);
        this.keyPanel.add(this.resultSymbolKey);
    }

    /**
     * Updates the state of the button (member variables) when triggered
     * Currently not used
     *
     * @param o   Observable class that the call (trigger came from)
     * @param arg An object specified in the notifyObserver, contains the new state.
     */
    @Override
    public void update(Observable o, Object arg) {
        // Not used
    }

    /**
     * @see IView#getGUI()
     */
    @Override
    public JComponent getGUI() {
        return this.keyPanel;
    }
}

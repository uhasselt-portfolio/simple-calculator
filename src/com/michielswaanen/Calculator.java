package com.michielswaanen;

import com.michielswaanen.controller.CalculatorController;
import com.michielswaanen.model.CalculatorModel;
import com.michielswaanen.view.CalculatorKeyboardView;
import com.michielswaanen.view.CalculatorScreenView;

import javax.swing.*;

public class Calculator {

    private CalculatorKeyboardView buttonView;
    private CalculatorScreenView screenView;

    public Calculator() {
        CalculatorModel model = new CalculatorModel();

        this.buttonView = new CalculatorKeyboardView(new CalculatorController(model));
        model.addObserver(this.buttonView);

        this.screenView = new CalculatorScreenView();
        model.addObserver(this.screenView);
    }

    /**
     * Creates a desktop window application and launches the application
     */
    public void start() {
        JFrame frame = new JFrame("Calculator");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.getContentPane().add(this.screenView.getGUI());
        frame.getContentPane().add(this.buttonView.getGUI());

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Initialization of the calculator
     */
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.start();
    }
}

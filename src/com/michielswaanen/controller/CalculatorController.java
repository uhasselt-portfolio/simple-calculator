package com.michielswaanen.controller;

import com.michielswaanen.model.CalculatorModel;

import javax.script.ScriptException;
import java.util.Observable;

public class CalculatorController extends AbstractController
{
    public CalculatorController(Observable model) {
        super(model);
    }

    /**
     * Called when = is pressed, calculates the equation
     * Throws an error when the equation is not valid
     */
    public void onCalculate() {
        try {
            ((CalculatorModel) getModel()).calculate();
        } catch (ScriptException e) {
            ((CalculatorModel) getModel()).clearScreen();
        }
    }

    /**
     * Called when any key is pressed, except for =
     * Adds the pressed element (value) to the equation
     *
     * @pre value   Not allowed to be null
     * @pre value   Must be a numeric value or a + - * /
     * @param value The pressed value on the calculator keyboard
     */
    public void onKeyPress(String value) {
        ((CalculatorModel) getModel()).addElementToEquation(value);
    }
}

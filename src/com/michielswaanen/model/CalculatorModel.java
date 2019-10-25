package com.michielswaanen.model;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Observable;

public class CalculatorModel extends Observable {

    private String equation;

    public CalculatorModel() {
        this.equation = new String();
    }

    /**
     * Calculate the expression inside the equation member variable
     *
     * @throws ScriptException when the equation is not a valid expression
     */
    public void calculate() throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        Object result = engine.eval(this.equation);

        this.equation = result.toString();

        setChanged();
        notifyObservers(this.equation);

        this.equation = "";
    }

    /**
     * Add an element to the equation, called when a key is pressed.
     *
     * @param element that gets added to the equation member variable
     */
    public void addElementToEquation(String element) {
        this.equation += element;

        setChanged();
        notifyObservers(this.equation);
    }

    /**
     * Clear the memory and update the screen of the calculator
     */
    public void clearScreen() {
        this.equation = "";

        setChanged();
        notifyObservers(this.equation);
    }
}

package com.michielswaanen.controller;

import com.michielswaanen.view.IView;

import java.util.Observable;

public interface IController {

    /**
     * Set the view (not used)
     *
     * @pre view   Not allowed to be null
     * @param view An implemented instance of IView
     */
    void setView(IView view);

    /**
     * Get the view (not used)
     *
     * @return An implemented instance of IView
     */
    IView getView();

    /**
     * Set the model in the controller (not used, did the initialization in the Calculator constructor)
     *
     * @pre model   Not allowed to be null
     * @param model An implemented instance of CalculatorModel
     */
    void setModel(Observable model);

    /**
     * Get the model, the state of the object is saved here
     *
     * @return CalculatorModel, Observable is the underlying class
     */
    Observable getModel();
}

package com.michielswaanen.view;

import com.michielswaanen.controller.IController;

import javax.swing.*;

public interface IView {

    /**
     * Set the controller in the view (not used, did the initialization in the constructor)
     *
     * @pre controller   Not allowed to be null
     * @param controller An implemented version of controller
     */
    void setController(IController controller);

    /**
     * Get the controller, the controller can communicate with the model
     *
     * @return An implemented instance of IController
     */
    IController getController();

    /**
     * Get all the components glued together as one object (a visible module of the desktop application)
     *
     * @return JComponent that contains all the individual visible java components
     */
    JComponent getGUI();
}

package com.michielswaanen.view;

import com.michielswaanen.controller.IController;

import java.util.Observer;

public abstract class AbstractView implements IView, Observer {

    private IController controller;

    public AbstractView() {}

    public AbstractView(IController controller) {
        this.controller = controller;
    }

    /**
     * @see IView#setController(IController)
     */
    @Override
    public void setController(IController controller) {
        this.controller = controller;
    }

    /**
     * @see IView#getController()
     */
    @Override
    public IController getController() {
        return this.controller;
    }
}

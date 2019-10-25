package com.michielswaanen.controller;

import com.michielswaanen.view.IView;

import java.util.Observable;

public abstract class AbstractController implements IController {

    private IView view;
    private Observable model;

    public AbstractController(Observable model) {
        this.model = model;
    }

    /**
     * @see IController#setView(IView)
     */
    @Override
    public void setView(IView view) {
        this.view = view;
    }

    /**
     * @see IController#getView()
     */
    @Override
    public IView getView() {
        return this.view;
    }

    /**
     * @see IController#setModel(Observable)
     */
    @Override
    public void setModel(Observable model) {
        this.model = model;
    }

    /**
     * @see  IController#getModel()
     */
    @Override
    public Observable getModel() {
        return this.model;

    }
}

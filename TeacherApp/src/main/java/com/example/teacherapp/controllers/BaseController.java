package com.example.teacherapp.controllers;

import com.example.teacherapp.LoginApplication;
import javafx.scene.Node;

import java.sql.SQLException;

public abstract class BaseController implements Controller {

    private Node view;

    @Override
    public Node getView() {
        return view;
    }

    @Override
    public void setView (Node view){
        this.view = view;
    }

    @Override
    public void Show() {
        PreShowing();
        LoginApplication.getNavigation().Show(this);
        PostShowing();
    }

    public void PreShowing()
    {
    }

    public void PostShowing()
    {
    }

    abstract void initialize() throws SQLException;
}

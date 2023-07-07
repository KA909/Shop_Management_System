package com.example.demo.util;

import javafx.stage.Stage;

import java.util.ArrayList;

public class StageController {
    private static StageController controller;
    private Stage stage ;

    private StageController(){
    }

    public static StageController init(){
        return (controller==null) ? controller = new StageController() : controller;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}

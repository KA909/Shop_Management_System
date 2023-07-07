package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;

public class MainFormController {
    public AnchorPane root;
    public Label q1p1;
    public Label q2p1;
    public Label q3p1;
    public Label q1p2;
    public Label q2p2;
    public Label q2p3;
    public Label q3p2;
    public Label q3p3;
    public Label q3p4;
    public Label q3p5;
    @FXML
    private Label welcomeText;




    public void currentCustomer(ActionEvent actionEvent) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("currentcustomers.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void waitingCustomer(ActionEvent actionEvent) throws IOException {
        System.out.println("hi");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("waitingcustomers.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    Customer[] Q1 = FoodQueue.returnQ1();
    Customer[] Q2 = FoodQueue.returnQ2();
    Customer[] Q3 = FoodQueue.returnQ3();
    public void relodeOnAction(ActionEvent actionEvent) {


        q1p1.setText(Q1[0].getStatus());
        q1p2.setText(Q1[1].getStatus());
        q2p1.setText(Q2[0].getStatus());
        q2p2.setText(Q2[1].getStatus());
        q2p3.setText(Q2[2].getStatus());
        q3p1.setText(Q3[0].getStatus());
        q3p2.setText(Q3[1].getStatus());
        q3p3.setText(Q3[2].getStatus());
        q3p4.setText(Q3[3].getStatus());
        q3p5.setText(Q3[4].getStatus());


    }

    public void q1p1OnAction(MouseEvent mouseEvent) {
        q1p1.setText(Q1[0].getFirstName());
    }

    public void q2p1OnAction(MouseEvent mouseEvent) {
        q2p1.setText(Q2[0].getFirstName());
    }

    public void q3p1OnAction(MouseEvent mouseEvent) {
        q3p1.setText(Q3[0].getFirstName());
    }

    public void q1p2OnAction(MouseEvent mouseEvent) {
        q1p2.setText(Q1[1].getFirstName());
    }


    public void q2p2OnAction(MouseEvent mouseEvent) {
        q2p2.setText(Q2[1].getFirstName());
    }

    public void q3p2OnAction(MouseEvent mouseEvent) {
        q3p2.setText(Q3[1].getFirstName());
    }

    public void q2p3OnAction(MouseEvent mouseEvent) {
        q2p3.setText(Q2[2].getFirstName());
    }

    public void q3p3OnAction(MouseEvent mouseEvent) {
        q3p3.setText(Q3[2].getFirstName());
    }


    public void q3p4OnAction(MouseEvent mouseEvent) {
        q3p4.setText(Q3[3].getFirstName());
    }

    public void q3p5OnAction(MouseEvent mouseEvent) {
        q3p5.setText(Q3[4].getFirstName());
    }
}
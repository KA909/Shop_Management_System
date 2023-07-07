package com.example.demo;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CurruntCustomerController {
    public TableView<Customer> currentCustomerTable;
    Customer[] Q1 = FoodQueue.returnQ1();
    Customer[] Q2 = FoodQueue.returnQ2();
    Customer[] Q3 = FoodQueue.returnQ3();

    public void loadTableOnAction(ActionEvent actionEvent) {
        currentCustomerTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Fname"));
        currentCustomerTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Lname"));
        currentCustomerTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Bcount"));


        ObservableList<Customer> data = FXCollections.observableArrayList();
        data.add(Q1[0]);
        data.add(Q1[1]);

        currentCustomerTable.setItems(data);


    }
}

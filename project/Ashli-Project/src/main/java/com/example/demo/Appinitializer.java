package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Appinitializer extends Application {
    Stage stage;
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Appinitializer.class.getResource("main-form.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) throws Exception {

        FoodQueue.clearConsole();
        FoodQueue.Init();

        Scanner input = new Scanner(System.in);
        FoodQueue.homepage();

        while (true) {
            String option;
            System.out.print("Enter an option to continue > ");
            option = input.nextLine();

            if (Objects.equals(option, "999") | Objects.equals(option, "EXT")) {
                break;
            }
            switch (option) {
                case "100":
                case "VFQ":
                    FoodQueue.viewAllQueues();
                    FoodQueue.homepage();
                    break;
                case "101":
                case "VEQ":
                    FoodQueue.viewAllEmptyQueues();
                    FoodQueue.homepage();
                    break;
                case "102":
                case "ACQ":
                    FoodQueue.addNewCustomer();
                    FoodQueue.printCustomers();
                    FoodQueue.homepage();
                    break;
                case "103":
                case "RCQ":
                    FoodQueue.removeCustomer();
                    FoodQueue.printCustomers();
                    FoodQueue.homepage();
                    break;
                case "104":
                case "PCQ":
                    FoodQueue.removeServedcustomer();
                    FoodQueue.printCustomers();
                    FoodQueue.homepage();
                    break;
                case "105":
                case "VCS":
                    FoodQueue.sortArray();
                    FoodQueue.homepage();
                    break;
                case "106":
                case "SPD":
                    FoodQueue.writeDataintoFile();
                    FoodQueue.homepage();
                    break;
                case "107":
                case "LPD":
                    FoodQueue.readFile();
                    FoodQueue.homepage();
                    break;
                case "108":
                case "STK":
                    FoodQueue.ViewRemainingBurgerStock();
                    FoodQueue.homepage();
                    break;
                case "109":
                case "AFS":
                    FoodQueue.AddBurgertoStock();
                    FoodQueue.homepage();
                    break;
                case "home":
                    launch();
                    FoodQueue.homepage();
                    break;
                default:
                    System.out.println("\t Invalid input...");
            }
        }
}
}



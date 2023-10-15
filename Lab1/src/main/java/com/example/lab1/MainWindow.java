package com.example.lab1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainWindow extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Laboratory work #1");

        // Create MenuBar
        MenuBar menuBar = new MenuBar();

        // Create menus
        Menu worksMenu = new Menu("Works");
        worksMenu.getStyleClass().add("menu");

        // Create MenuItems
        MenuItem inputWindowButton = new MenuItem("Work #1");
        MenuItem scrollbarWindowButton = new MenuItem("Work #2");



        // Add menu items to the Works menu
        worksMenu.getItems().addAll(inputWindowButton, scrollbarWindowButton);


        // Add menus to the menu bar
        menuBar.getMenus().addAll(worksMenu);

        Label label = new Label("Received input: ");
        label.setAlignment(Pos.CENTER);

        inputWindowButton.setOnAction(e -> {
            // Create a new ScrollbarWindow and open it
            InputWindow inputWindow = new InputWindow(
                    value -> {
                        // Add your logic here to handle the value
                        System.out.println("Received value from input window: " + value);
                        label.setText("Received input: " + value);
                    },
                    () -> {
                        // Add your logic here to clear the input
                        System.out.println("Cancel button clicked");
                        label.setText("Received input: ");
                    }
            );
            Stage stage = new Stage();
            try {
                inputWindow.start(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });




        scrollbarWindowButton.setOnAction(e -> {
            // Create a new ScrollbarWindow and open it
            ScrollbarWindow scrollbarWindow = new ScrollbarWindow(
                    value -> {
                        // Add your logic here to handle the value
                        System.out.println("Received value from scrollbar window: " + value);
                        label.setText("Received input: " + value);
                    },
                    () -> {
                        // Add your logic here to clear the input
                        System.out.println("Cancel button clicked");
                        label.setText("Received input: ");
                    }
            );
            Stage stage = new Stage();
            try {
                scrollbarWindow.start(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });


        BorderPane borderPane = new BorderPane();
        borderPane.setTop(menuBar);
        borderPane.setCenter(label);

        Scene scene = new Scene(borderPane, 400, 300);
        scene.getStylesheets().add(getClass().getResource("/com/example/lab1/mainWindow.css").toExternalForm());
        primaryStage.setScene(scene);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

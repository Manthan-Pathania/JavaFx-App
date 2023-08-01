package com.example.javafxapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class HelloApplication extends Application {

    public void init() throws Exception {
        System.out.println("inti");  // intialise your application
        super.init();
    }



    @Override
    public void start(Stage stage) throws IOException {

        System.out.println("start");  // starts an application
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));

        VBox rootnode = fxmlLoader.load();


        MenuBar menuBar = createMenu();
        rootnode.getChildren().add(0,menuBar);
        Scene scene = new Scene(rootnode);
        stage.setTitle("TEMPERATURE CONVERTOR TOOL");
        stage.setScene(scene);
//        stage.setResizable(false);   // makes your application non resizable
        stage.show();
    }

    private MenuBar createMenu(){

        SeparatorMenuItem newSeparator = new SeparatorMenuItem();

        Menu fileMenu = new Menu("FILE");
        MenuItem newMenuItem = new MenuItem("NEW");
        newMenuItem.setOnAction(actionEvent -> System.out.println("new item clicked"));

        MenuItem quitMenuItem = new MenuItem("QUIT");
        fileMenu.getItems().addAll(newMenuItem,newSeparator,quitMenuItem);
        quitMenuItem.setOnAction(eventio -> {
            Platform.exit();
            System.exit(0);
        });

        Menu helpMenu = new Menu("HELP");
        MenuItem aboutMenuItem = new MenuItem("ABOUT");
        helpMenu.getItems().addAll(aboutMenuItem);
        aboutMenuItem.setOnAction(event -> {aboutApp();});

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu , helpMenu);
        return menuBar;
    }

    private void aboutApp(){
        Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("My first desktop app");
        alertDialog.setHeaderText("Learning javafx app");
        alertDialog.setContentText("I am a begineer but soon i will be a pro and will make desktop games");

        // customizable dialog
        ButtonType yesbtn = new ButtonType("Yes");
        ButtonType nobtn = new ButtonType("No");
        alertDialog.getButtonTypes().setAll(yesbtn , nobtn);    // replace previous buttons, whereass addAll will add them keeping the previosu one

        Optional<ButtonType> clickedButton = alertDialog.showAndWait();

        if (clickedButton.isPresent() && clickedButton.get() == yesbtn){
            System.out.println("yes button is clikced");
        } else if (clickedButton.isPresent() && clickedButton.get() == nobtn) {
            System.out.println("no button is clicked");

        }
    }

    public void stop() throws Exception{
        System.out.println("stop");   // called when application is stopped and is about to shutdown
        super.stop();
    }

    public static void main(String[] args) {
        System.out.println("main");   // runs first
        launch();
    }
}

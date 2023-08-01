package com.example.javafxapp;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;



public class HelloController implements Initializable {

    @FXML
    public Label welcomeLable;

    @FXML
    public ChoiceBox<String> choiceBox;

    @FXML
    public TextField text;

    @FXML
    public Button convertButton;

    private static final String c_t_f = "Celcius to Farnehit";
    private static final String f_t_c = "Farnehit to Celcius";

    private boolean isc_t_f = true;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        choiceBox.getItems().add(c_t_f);
        choiceBox.getItems().add(f_t_c);

        choiceBox.setValue(c_t_f);

        choiceBox.getSelectionModel().selectedItemProperty().addListener( (observableValue, o, t1) -> {
            if (t1.equals(c_t_f)){
                isc_t_f = true;
            }else{
                isc_t_f = false;
            }

        });

        convertButton.setOnAction(event -> {
            covert();
        });

    }

    private void covert() {
        String input = text.getText();

        float Temp = 0.0f ;

        try {
             Temp = Float.parseFloat(input);
        }catch (Exception exception){
            warnuser();
            return;
        }

        float newTemp = 0.0f;

        if (isc_t_f ){
            newTemp = (Temp * 9/5) + 32 ;
        }else{
            newTemp = (Temp - 32) * 5/9 ;
        }

        display(newTemp);
    }

    private void warnuser() {
        Alert disp = new Alert(Alert.AlertType.ERROR);
        disp.setTitle("Error Occured");
        disp.setHeaderText("Invalid Temperature Entered");
        disp.setContentText("Enter Valid Temperature");
        disp.show();
    }

    private void display(float newTemp){

        String unit = isc_t_f? "F" : "C" ;

        System.out.println("The new temp is " + newTemp + " " + unit);

        Alert disp = new Alert(Alert.AlertType.INFORMATION);
        disp.setTitle("Result");
        disp.setContentText("The new temp is " + newTemp + " " + unit);
        disp.show();
    }
}
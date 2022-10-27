package controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class IngresoController {

    @FXML
    private Button ingresoConsultorButton;

    @FXML
    private Button ingresoCuestionarioButton;

    @FXML
    private Button salirButton;

    @FXML
    void ingresoConsultorClicked(ActionEvent event) throws IOException {
Parent root = FXMLLoader.load((getClass().getResource("/views/ValidarUsuarioConsultor.fxml")));
    	
    	Stage window = (Stage)ingresoConsultorButton.getScene().getWindow();
    	window.setScene(new Scene(root));
    	
    	
    }

    @FXML
    void ingresoCuestionarioClicked(ActionEvent event) {

    }

    @FXML
    void salirClicked(ActionEvent event) {

    }

}

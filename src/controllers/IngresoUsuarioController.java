package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class IngresoUsuarioController {

    @FXML
    private TextField contrasenaTextField;

    @FXML
    private Button ingresarButton;

    @FXML
    private Button salirButton;

    @FXML
    private TextField usuarioTextField;

    @FXML
    private Button volverButton;
    @FXML
    private AnchorPane scenePane;

    @FXML
    void ingresarButtonClicked(ActionEvent event) {
    	Parent root;
		try {
			root = FXMLLoader.load((getClass().getResource("/views/UsuarioConsultor.fxml")));
			Stage window = (Stage)ingresarButton.getScene().getWindow();
			window.setTitle("Usuario consultor");
	    	window.setScene(new Scene(root));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }

    @FXML
    void salirButtonClicked(ActionEvent event) {
    	Stage stage = (Stage) scenePane.getScene().getWindow();
    	stage.close();

    }

    @FXML
    void volverButtonClicked(ActionEvent event) {
    	Parent root;
		try {
			root = FXMLLoader.load((getClass().getResource("/views/PantallaIngreso.fxml")));
			Stage window = (Stage)volverButton.getScene().getWindow();
			window.setTitle("Ingreso al sistema");
	    	window.setScene(new Scene(root));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}

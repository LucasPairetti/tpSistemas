package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class IngresoCandidatoController implements Initializable {

    @FXML
    private Button ingresarButton;

    @FXML
    private CheckBox mostrarContraseñaCheck;

    @FXML
    private PasswordField passwordFieldHidden;

    @FXML
    private TextField passwordFieldShowed;

    @FXML
    private Button salirButton;

    @FXML
    private AnchorPane scenePane;

    @FXML
    private ComboBox<String> tipoDocComboBox;

    @FXML
    private TextField usuarioTextField;

    @FXML
    private Button volverButton;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
    	tipoDocComboBox.setItems(FXCollections.observableArrayList("DNI","Pasaporte"));
	}

    @FXML
    void MostrarContraseña(ActionEvent event) {

    }

    @FXML
    void ingresarButtonClicked(ActionEvent event) {

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



package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class UsuarioConsultorController {

    @FXML
    private Button competenciasButton;

    @FXML
    private Button evaluarCandidatosButton;

    @FXML
    private Button exportarResultadosButton;

    @FXML
    private Button factoresButton;

    @FXML
    private Button gestionarCandidatosButton;

    @FXML
    private Button importarCandidatosButton;

    @FXML
    private Button ordenMeritoButton;

    @FXML
    private Button preguntasButton;

    @FXML
    private Button puestosButton;

    @FXML
    private Button reporteComparativoButton;

    @FXML
    private Button salirButton;

    @FXML
    void competenciasButtonClicked(ActionEvent event) {

    }

    @FXML
    void evaluarCandidatosButtonClicked(ActionEvent event) {

    }

    @FXML
    void exportarResultadosButtonClicked(ActionEvent event) {

    }

    @FXML
    void factoresButtonClicked(ActionEvent event) {

    }

    @FXML
    void gestionarCandidatosButtonClicked(ActionEvent event) {

    }

    @FXML
    void importarCandidatosButtonClicked(ActionEvent event) {

    }

    @FXML
    void ordenMeritoButtonClicked(ActionEvent event) {

    }

    @FXML
    void preguntasButtonClicked(ActionEvent event) {

    }

    @FXML
    void puestosButtonClicked(ActionEvent event) {
    	
    	
    	Parent root;
		try {
			root = FXMLLoader.load((getClass().getResource("/views/GestionarPuesto.fxml")));
			Stage window = (Stage)puestosButton.getScene().getWindow();
			window.setTitle("Gestionar Puestos");
	    	window.setScene(new Scene(root));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @FXML
    void reporteComparativoButtonClicked(ActionEvent event) {

    }

    @FXML
    void salirButtonClicked(ActionEvent event) {
Parent root;
try {
	root = FXMLLoader.load((getClass().getResource("/views/ValidarUsuarioConsultor.fxml")));
	Stage window = (Stage)salirButton.getScene().getWindow();
	window.setTitle("Validar usuario consultor");
	window.setScene(new Scene(root));
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
    	
    	
    }
    }



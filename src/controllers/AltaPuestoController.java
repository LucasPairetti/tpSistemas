package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import entidades.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AltaPuestoController implements Initializable {

    @FXML
    private Button AceptarButton;

    @FXML
    private Button agregarButton;

    @FXML
    private Button cancelarButton;

    @FXML
    private TextField codigoTextField;

    @FXML
    private TableColumn<Competencia, String> competenciaColumn;

    @FXML
    private TextArea descripcionTextArea;

    @FXML
    private Button eliminarButton;

    @FXML
    private TextField empresaTextField;

    @FXML
    private TableColumn<ItemCompetencia, Integer> ponderacionColumn;

    @FXML
    private TextField puestoTextField;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

    @FXML
    private TableView<ItemCompetencia> tableView;

    @FXML
    void AceptarButtonClicked(ActionEvent event) {

    }

    @FXML
    void agregarButtonClicked(ActionEvent event) {

    }

    @FXML
    void cancelarButtonClicked(ActionEvent event) {
    	Parent root;
		try {
			root = FXMLLoader.load((getClass().getResource("/views/GestionarPuesto.fxml")));
			Stage window = (Stage)cancelarButton.getScene().getWindow();
			window.setTitle("Gestionar puesto");
	    	window.setScene(new Scene(root));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @FXML
    void eliminarButtonClicked(ActionEvent event) {

    }

	

}

package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import entidades.*;
import gestores.GestorDePuesto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class GestionarPuestoController implements Initializable {

	GestorDePuesto gestorPuestos = GestorDePuesto.getInstance();
	
    @FXML
    private Button buscarButton;

    @FXML
    private TableColumn<Puesto, Integer> codigoColumn;

    @FXML
    private TextField codigoTextField;

    @FXML
    private Button editarButton;

    @FXML
    private Button eliminarButton;

    @FXML
    private TableColumn<Puesto, String> empresaColumn;

    @FXML
    private TextField empresaTextField;

    @FXML
    private Button limpiarButton;

    @FXML
    private Button nuevoButton;

    @FXML
    private TableColumn<Puesto, String> puestoColumn;

    @FXML
    private TextField puestoTextField;

    @FXML
    private Button salirButton;

    @FXML
    private TableView<Puesto> tableView;
    
    ObservableList<Puesto> listaPuestos= FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        listaPuestos.addAll(gestorPuestos.getAllPuestos());

        codigoColumn.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        puestoColumn.setCellValueFactory(new PropertyValueFactory<>("nombrePuesto"));
        empresaColumn.setCellValueFactory(new PropertyValueFactory<>("empresa"));

        tableView.setItems(listaPuestos);

    }

    @FXML
    void buscarButtonClicked(ActionEvent event) {

    }

    @FXML
    void editarButtonClicked(ActionEvent event) {

    }

    @FXML
    void eliminarButtonClicked(ActionEvent event) {

    }

    @FXML
    void limpiarButtonClicked(ActionEvent event) {

    }

    @FXML
    void nuevoButtonClicked(ActionEvent event) {
    	Parent root;
		try {
			root = FXMLLoader.load((getClass().getResource("/views/AltaPuesto.fxml")));
			Stage window = (Stage)nuevoButton.getScene().getWindow();
			window.setTitle("Dar de alta puesto");
	    	window.setScene(new Scene(root));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void salirButtonClicked(ActionEvent event) {
    	Parent root;
		try {
			root = FXMLLoader.load((getClass().getResource("/views/UsuarioConsultor.fxml")));
			Stage window = (Stage)salirButton.getScene().getWindow();
			window.setTitle("usuario consultor");
	    	window.setScene(new Scene(root));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }

	

}

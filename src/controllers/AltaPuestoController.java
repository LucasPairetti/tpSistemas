package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import entidades.*;
import gestores.GestorDeCompetencias;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AltaPuestoController implements Initializable {
	GestorDePuesto gestorPuesto = GestorDePuesto.getInstance();
	GestorDeCompetencias gestorCompetencias = GestorDeCompetencias.getInstance();


    @FXML
    private Button AceptarButton;

    @FXML
    private Button agregarItemButton;

    @FXML
    private Button cancelarButton;

    @FXML
    private TextField codigoTextField;

    @FXML
    private TableColumn<Competencia, String> competenciaColumn;

    @FXML
    private TableColumn<ItemCompetencia, String> competenciaItemColumn;

    @FXML
    private TableView<Competencia> competenciasTableView;

    @FXML
    private TextArea descripcionTextArea;

    @FXML
    private Button eliminarItemButton;

    @FXML
    private TextField empresaTextField;

    @FXML
    private TableView<ItemCompetencia> itemCompetenciatableView;

    @FXML
    private TableColumn<ItemCompetencia, Integer> ponderacionColumn;

    @FXML
    private TextField ponderacionTextField;

    @FXML
    private TextField puestoTextField;
    
    private List<ItemCompetencia> listadoDeCompetencias = new ArrayList<ItemCompetencia>();
    
    
    ObservableList<ItemCompetencia> listaItemCompetencia = FXCollections.observableArrayList();  
    ObservableList<Competencia> listaCompetencias= FXCollections.observableArrayList(); 
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		//buscar todas las competencias y agregarlas a listaCompetencias
    	listaCompetencias = (ObservableList<Competencia>) gestorCompetencias.getAllCompetencia();
    	//formatear tablas
    	ObservableList<ItemCompetencia> listaItemCompetencia = FXCollections.observableArrayList();  
        ObservableList<Competencia> listaCompetencias= FXCollections.observableArrayList(); 
        
        
    	competenciaColumn.setCellValueFactory(new PropertyValueFactory<>("competencia"));
    	competenciaItemColumn.setCellValueFactory(new PropertyValueFactory<>("nombreCompetencia"));
    	ponderacionColumn.setCellValueFactory(new PropertyValueFactory<>("ponderacion"));
    	
    	Competencia pruebaCompetencia = new Competencia( 1, 1234,"Lealtad", "prueba de lealtad");
    	listaCompetencias.add(pruebaCompetencia);
    	
    	//mostrarlas
    	competenciasTableView.setItems(listaCompetencias);
    	
	}

   

    @FXML
    void AceptarButtonClicked(ActionEvent event) {
    	
    	if(!(codigoTextField.getText()== null || puestoTextField.getText() == null || descripcionTextArea.getText() ==null) )
    	//este crear puesto es un fake de prueba
    	gestorPuesto.crearPuesto(0, Integer.parseInt(codigoTextField.getText()), puestoTextField.getText(), empresaTextField.getText(), descripcionTextArea.getText(), listadoDeCompetencias);
    	

    }
    
    @FXML
    void agregarItemButtonClicked(ActionEvent event) {
    	Competencia competenciaElegida = competenciasTableView.getSelectionModel().getSelectedItem();
    	ItemCompetencia nuevoItemCompetencia = new ItemCompetencia (competenciaElegida, Integer.parseInt(ponderacionTextField.getText()));
    	listadoDeCompetencias.add(nuevoItemCompetencia);
    	listaItemCompetencia.add(nuevoItemCompetencia);
    	itemCompetenciatableView.setItems(listaItemCompetencia);
    	
    	

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
    void eliminarItemButtonClicked(ActionEvent event) {

    }
	

}

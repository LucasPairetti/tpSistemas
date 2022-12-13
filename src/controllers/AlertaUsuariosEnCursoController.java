package controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import DTOS.CandidatoDTO;
import entidades.Candidato;
import entidades.Puesto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AlertaUsuariosEnCursoController implements Initializable{

    @FXML
    private TableView<CandidatoDTO> CandidatosTable;

    @FXML
    private TableColumn<CandidatoDTO, String> apellidoColumn;

    @FXML
    private TableColumn<CandidatoDTO, String> nombreColumn;

    @FXML
    private AnchorPane panel;
    
    @FXML
    private TableColumn<CandidatoDTO, String> nroCandidato;
    
    

    @FXML
    private Button volverButton;
    
    private List<CandidatoDTO> candidatosEnCurso;

    @FXML
    void volverButtonClicked(ActionEvent event) {
    	Stage stage = (Stage) panel.getScene().getWindow();
    	stage.close();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		ObservableList<CandidatoDTO> listaListaCandidatos= (ObservableList<CandidatoDTO>) candidatosEnCurso;
		nombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		apellidoColumn.setCellValueFactory(new PropertyValueFactory<>("apellido"));
		nroCandidato.setCellValueFactory(new PropertyValueFactory<>("nroCandidato"));
		CandidatosTable.setItems(listaListaCandidatos);
	
	}
	
	public void setCandidatosEnCurso (List<CandidatoDTO> lista) {
		candidatosEnCurso=lista;	
	}

}


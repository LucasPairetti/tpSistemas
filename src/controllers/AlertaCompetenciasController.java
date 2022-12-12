package controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import DTOS.CompetenciaDTO;
import entidades.Candidato;
import entidades.Competencia;
import entidades.ItemCompetencia;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AlertaCompetenciasController implements Initializable {

    @FXML
    private Button aceptarButton;

    @FXML
    private TableColumn<CompetenciaDTO, String> competenciaColumn;

    @FXML
    private TableView<CompetenciaDTO> competenciaTable;

    @FXML
    private AnchorPane panel;

    ObservableList<CompetenciaDTO> listaItemCompetencia = FXCollections.observableArrayList();  
    private List<CompetenciaDTO> competencias;
    
    @FXML
    void aceptarButtonClicked(ActionEvent event) {
    	Stage stage = (Stage) panel.getScene().getWindow();
    	stage.close();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// TODO Auto-generated method stub
		listaItemCompetencia.addAll(competencias);
		competenciaColumn.setCellValueFactory(new PropertyValueFactory<>("nombreCompetencia"));
		competenciaTable.setItems(listaItemCompetencia);
		
	}
	
	public void agregarCompetencias(List<CompetenciaDTO> lista) {
		competencias=lista;
	}

}

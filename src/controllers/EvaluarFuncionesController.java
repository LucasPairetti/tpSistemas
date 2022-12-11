package controllers;

import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import entidades.Competencia;
import entidades.ItemCompetencia;
import entidades.Puesto;
import gestores.GestorDePuesto;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EvaluarFuncionesController implements Initializable {

    @FXML
    private TableView<?> CandidatoTableView;

    @FXML
    private TableColumn<?, ?> apellidoColumn;

    @FXML
    private Button cancelarButton;

    @FXML
    private TableColumn<?, ?> competenciaColumn;

    @FXML
    private TableView<?> competenciasTableView;

    @FXML
    private Button finalizarButton;

    @FXML
    private TableColumn<?, ?> nombreColumn;

    @FXML
    private TableColumn<?, ?> ponderacionColumn;

    @FXML
    private ChoiceBox<?> puestosChoiceBox;

    @FXML
    private Button salirButton;

    @FXML
    private AnchorPane scenePane;

    @FXML
    private Button siguienteButton;

    @FXML
    void cancelarButtonClicked(ActionEvent event) {

    }

    @FXML
    void finalizarButtonClicked(ActionEvent event) {

    }

    @FXML
    void salirClicked(ActionEvent event) {

    }

    @FXML
    void siguienteButtonClicked(ActionEvent event) {
    	
    	GestorDePuesto gestorPuesto = GestorDePuesto.getInstance();
    	if(!gestorPuesto.validarFactores(puestoDTO) {alertaCompetencias(null); return;}
    	
    	//Se muestran itemCompetencia
    	
    }
    
    
    void alertaCompetencias(List<Competencia> listaCompetencias) {
    	Stage alertaStage = new Stage();
    	Parent root;
		try {
			root = FXMLLoader.load((getClass().getResource("/views/alertaCompetenciaEvaluar.fxml")));
			Scene scene = new Scene(root);
			alertaStage.setTitle("Candidatos en curso");
			alertaStage.setScene(scene);
			alertaStage.show();
	    	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		GestorDePuesto gestorPuesto = GestorDePuesto.getInstance();
		List<Puesto> listaPuestos = gestorPuesto.getAllPuestos();
	}

}

package controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import entidades.Candidato;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class AlertaUsuariosEnCursoController implements Initializable{

    @FXML
    private TableView<Candidato> CandidatosTable;

    @FXML
    private TableColumn<Candidato, String> apellidoColumn;

    @FXML
    private TableColumn<Candidato, String> nombreColumn;

    @FXML
    private AnchorPane panel;
    
   

    @FXML
    private Button volverButton;
    
    private List<Candidato> candidatosEnCurso;

    @FXML
    void volverButtonClicked(ActionEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
	}

}

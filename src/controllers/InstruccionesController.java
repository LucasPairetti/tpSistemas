package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import entidades.*;
import gestores.GestorDeAutenticacion;
import gestores.GestorDeCuestionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class InstruccionesController implements Initializable{

	  @FXML
	    private Button siguienteButton;


	    @FXML
	    void siguienteButtonClicked(ActionEvent event) {
    	
    	GestorDeCuestionario gestorCuestionario = GestorDeCuestionario.getInstance();
    	
    	gestorCuestionario.IniciarCuestionario(gestorCuestionario.getIdCuestionario());
    	
    	FXMLLoader loader = new FXMLLoader((getClass().getResource("/views/CompletarCuestionario.fxml")));

		try {
			
			
			
			Parent root = (Parent)loader.load();
			
			Stage window = new Stage();
			window.setTitle("Resolver cuestionario");
	    	window.setScene(new Scene(root));
	    	
	    	window.show();
	    	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// TODO Auto-generated method stub
    	
		
	}

}

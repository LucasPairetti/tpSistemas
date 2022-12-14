package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import entidades.*;
import gestores.GestorDeAutenticacion;
import gestores.GestorDeCuestionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class InstruccionesController implements Initializable{

    @FXML
    private Button Ac;

    @FXML
    void salirButtonClicked(ActionEvent event) {
    	
    	System.out.println("Entre");
    	
    	GestorDeCuestionario gestorCuestionario = GestorDeCuestionario.getInstance();
    	
    	gestorCuestionario.IniciarCuestionario(gestorCuestionario.getIdCuestionario());
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// TODO Auto-generated method stub
    	
		
	}

}

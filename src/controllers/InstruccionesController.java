package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import entidades.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class InstruccionesController implements Initializable{

    @FXML
    private Button Ac;

    @FXML
    void salirButtonClicked(ActionEvent event) {

    }
    
    private int idcuestionario;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// TODO Auto-generated method stub
    	/*
    	 * Cuestionario cuestionario = getCuestionario(idCuestionario);
    	 * 
    	 * if(cuestionario.getEstado().getTipoEstado()=="EnProceso"){
    	 * 	if(cuestionario.getFechaFinal().IsAfter(Date.today){
    	 * cuestionario.getEstado().SetTipoEstado("incompleto");
    	 *  cuestionario.getEstado().Setfecha(new Date());
    	 *  
    	 *  Alert alerta= new Alert(Alert.AlertType.WARNING);
            	alerta.setTitle("El tiempo ha expirado");
            	alerta.setContentText("El tiempo del cuestionario a expirado");
            	alerta.showAndWait();
    	 * }
    	 * if((cuestionario.getCantidadAccesos()+1)>3)
    	 * cuestionario.getEstado().SetTipoEstado("incompleto");
    	 *  cuestionario.getEstado().Setfecha(new Date());
    	 *  
    	 *  Alert alerta= new Alert(Alert.AlertType.WARNING);
            	alerta.setTitle("Cantidad de accesos");
            	alerta.setContentText("A superado la cantidad de ingresos permitidos");
            	alerta.showAndWait();
    	 *  
    	 * }
    	 * 	
    	 * 
    	 * 
    	 */

		
		
	}

}

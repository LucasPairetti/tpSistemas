package application;
	
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import gestores.*;
import entidades.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			
			Parent root = FXMLLoader.load((getClass().getResource("/views/PantallaIngreso.fxml")));
			
			Scene scene = new Scene(root);
			primaryStage.setTitle("Ingreso al sistema");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Pregunta pregunta1 = new Pregunta(null, "Pregunta1", "Con cuál de las siguientes frases te identificas más\r\n"
				+ "en tu vida profesional:", "", null, null);
		Pregunta pregunta2 = new Pregunta(null, "Pregunta2", "Para mí el logro de objetivos colectivos es\r\n"
				+ "importante porque:", "", null, null);
		List<Pregunta> listaDePreguntas = new ArrayList<Pregunta>();
		listaDePreguntas.add(pregunta1);
		listaDePreguntas.add(pregunta2);
		Factor factor1 = new Factor("Credibilidad", 1, "Debe ser honesto y poder probarlo.", 1, listaDePreguntas);
		Factor factor2 = new Factor("Compromiso", 1, "Debe mostrar compromiso con sus tareas.", 1, null);
		List<Factor> listaDeFactores = new ArrayList<Factor>();
		listaDeFactores.add(factor1);
		listaDeFactores.add(factor2);
		GestorDeCompetencias gestorDeCompetencia = GestorDeCompetencias.getInstance();
		gestorDeCompetencia.createCompetencia(1, "Lealtad", "Debe ser leal a la empresa.", listaDeFactores);
		GestorDePuesto gestorDePuesto = GestorDePuesto.getInstance();
		gestorDePuesto.createPuesto(1, "Gerente", "McDonalds", "3 anios de experiencia como minimo.", null);
		Calendar calendario = Calendar.getInstance();
		calendario.set(2000, 11, 3);
		Date fechaNacimiento = calendario.getTime();
		GestorDeConsultor gestorConsultor = GestorDeConsultor.getInstance();
		gestorConsultor.createConsultor("TomasDannunzio", "Ramona123");
		GestorDeCandidato gestorCandidato = GestorDeCandidato.getInstance();
		gestorCandidato.createCandidato(42870674, "ABCDE123", null, "DNI", null, 1, "Tomas", "Dannunzio", fechaNacimiento, "Argentina", "tomidannunzio@gmail.com", "Universitario", false);
		
		launch(args);
		
	}
}

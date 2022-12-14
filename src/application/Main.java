package application;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import entidades.*;
import gestores.*;
/*
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import DAOS.HibernateUtil;
import java.util.ArrayList;
import java.util.Calendar;
import gestores.*;
import entidades.*;
*/
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
		
		/*
		//Creo respuestas
		Respuesta respuesta1 = new Respuesta("Soy digno de confianza, porque a través de mis hechos profesionales lo demuestro.", 1);
		Respuesta respuesta2 = new Respuesta("Cumplo de manera íntegra con lo que se me pide en el trabajo.", 2);
		Respuesta respuesta3 = new Respuesta("Guardo los intereses de la empresa sobre cualquier situación que pudiera afectarla.", 3);
		Respuesta respuesta4 = new Respuesta("Soy solidario con mis compañeros de trabajo buscando el bien de la empresa", 4);
		
		Respuesta respuesta5 = new Respuesta("Gracias a mi desempeño cotidiano mis compañeros de trabajo confían en mí.", 1);
		Respuesta respuesta6 = new Respuesta("Me gusta comprometerme con los proyectos que me asignan en el trabajo", 2);
		Respuesta respuesta7 = new Respuesta("La información que se genera en mi puesto la resguardo para el mejor uso por parte de la empresa", 3);
		Respuesta respuesta8 = new Respuesta("Soy partidario de ayudar a mis compañeros de trabajo, con tal de beneficiar los intereses laborales.", 4);
		
		
		List<Respuesta> listaRespuesta1 = new ArrayList<Respuesta>();
		listaRespuesta1.add(respuesta1);listaRespuesta1.add(respuesta2);
		List<Respuesta> listaRespuesta2 = new ArrayList<Respuesta>();
		listaRespuesta2.add(respuesta3);listaRespuesta2.add(respuesta4);
		List<Respuesta> listaRespuesta3 = new ArrayList<Respuesta>();
		listaRespuesta3.add(respuesta5);listaRespuesta3.add(respuesta6);
		List<Respuesta> listaRespuesta4 = new ArrayList<Respuesta>();
		listaRespuesta4.add(respuesta7);listaRespuesta4.add(respuesta8);
		
		//Creo Opcion De Respuesta
		OpcionDeRespuesta opcionDeRespuesta1 = new OpcionDeRespuesta("Opcion1", "Descripcion1", listaRespuesta1);
		OpcionDeRespuesta opcionDeRespuesta2 = new OpcionDeRespuesta("Opcion2", "Descripcion2", listaRespuesta2);
		OpcionDeRespuesta opcionDeRespuesta3 = new OpcionDeRespuesta("Opcion3", "Descripcion3", listaRespuesta3);
		OpcionDeRespuesta opcionDeRespuesta4 = new OpcionDeRespuesta("Opcion4", "Descripcion4", listaRespuesta4);
		
		//Creo ponderacion respuesta
		PonderacionRespuesta ponderacionRta1 = new PonderacionRespuesta(5, respuesta1);
		PonderacionRespuesta ponderacionRta2 = new PonderacionRespuesta(7, respuesta2);
		
		PonderacionRespuesta ponderacionRta3 = new PonderacionRespuesta(2, respuesta3);
		PonderacionRespuesta ponderacionRta4 = new PonderacionRespuesta(3, respuesta4);
		
		PonderacionRespuesta ponderacionRta5 = new PonderacionRespuesta(4, respuesta5);
		PonderacionRespuesta ponderacionRta6 = new PonderacionRespuesta(6, respuesta6);
		
		PonderacionRespuesta ponderacionRta7 = new PonderacionRespuesta(5, respuesta7);
		PonderacionRespuesta ponderacionRta8 = new PonderacionRespuesta(1, respuesta8);
		
		List<PonderacionRespuesta> listaPonderacionRespuesta1 = new ArrayList<PonderacionRespuesta>();
		listaPonderacionRespuesta1.add(ponderacionRta1);listaPonderacionRespuesta1.add(ponderacionRta2);
		List<PonderacionRespuesta> listaPonderacionRespuesta2 = new ArrayList<PonderacionRespuesta>();
		listaPonderacionRespuesta2.add(ponderacionRta3);listaPonderacionRespuesta2.add(ponderacionRta4);
		List<PonderacionRespuesta> listaPonderacionRespuesta3 = new ArrayList<PonderacionRespuesta>();
		listaPonderacionRespuesta3.add(ponderacionRta5);listaPonderacionRespuesta3.add(ponderacionRta6);
		List<PonderacionRespuesta> listaPonderacionRespuesta4 = new ArrayList<PonderacionRespuesta>();
		listaPonderacionRespuesta4.add(ponderacionRta7);listaPonderacionRespuesta4.add(ponderacionRta8);
		
		//Creo competencias
		GestorDeCompetencias gestorCompetencia = GestorDeCompetencias.getInstance();
		gestorCompetencia.createCompetencia(1, "Lealtad", "Debe ser leal a la empresa.", new ArrayList<Factor>());
		
		//Creo factores
		GestorDeFactor gestorFactor = GestorDeFactor.getInstance();
		gestorFactor.createFactor("Credibilidad", 1, "Debe ser honesto y poder probarlo.", 1, new ArrayList<Pregunta>());
		gestorFactor.createFactor("Compromiso", 2, "Debe mostrar compromiso con sus tareas.", 2, new ArrayList<Pregunta>());
		
		Factor factor1 = gestorFactor.getFactorByCodigo(1);
		Factor factor2 = gestorFactor.getFactorByCodigo(2);
		
		//Creo preguntas
		GestorDePregunta gestorPregunta = GestorDePregunta.getInstance();
		
		gestorPregunta.createPregunta(factor1, "Pregunta1", "Con cuál de las siguientes frases te identificas más en tu vida profesional:", "", opcionDeRespuesta1, listaPonderacionRespuesta1);
		gestorPregunta.createPregunta(factor1, "Pregunta2", "Para mí el logro de objetivos colectivos es importante porque:", "", opcionDeRespuesta2, listaPonderacionRespuesta2);
		List<Pregunta> listaDePreguntas = new ArrayList<Pregunta>();
		listaDePreguntas.add(gestorPregunta.getPreguntaById(1));
		listaDePreguntas.add(gestorPregunta.getPreguntaById(2));
		
		gestorPregunta.createPregunta(factor2, "Pregunta3", "Como calificarías tu compromiso?", "", opcionDeRespuesta3, listaPonderacionRespuesta3);
		gestorPregunta.createPregunta(factor2, "Pregunta4", "Por qué es importante para vos entrar en la empresa?", "", opcionDeRespuesta4, listaPonderacionRespuesta4);
		List<Pregunta> listaDePreguntas2 = new ArrayList<Pregunta>();
		listaDePreguntas2.add(gestorPregunta.getPreguntaById(3));
		listaDePreguntas2.add(gestorPregunta.getPreguntaById(4));
		
		//Asigno preguntas a factores
		factor1.getPreguntas().addAll(listaDePreguntas);
		gestorFactor.updateFactor(factor1);
		
		factor2.getPreguntas().addAll(listaDePreguntas2);
		gestorFactor.updateFactor(factor2);
		
		List<Factor> listaDeFactores = new ArrayList<Factor>();
		listaDeFactores.add(factor1);
		listaDeFactores.add(factor2);
		
		//Agrego factores a competencia
		Competencia competencia = gestorCompetencia.getCompetenciaByCodigo(1);
		competencia.getFactores().addAll(listaDeFactores);
		gestorCompetencia.updateCompetencia(competencia);
		
		//Creo itemCompetencias
		ItemCompetencia itemCompetencia1 = new ItemCompetencia(gestorCompetencia.getCompetenciaById(1),7);
		List<ItemCompetencia> listaItems = new ArrayList<ItemCompetencia>();
		listaItems.add(itemCompetencia1);
		
		//Creo puestos
		GestorDePuesto gestorDePuesto = GestorDePuesto.getInstance();
		gestorDePuesto.createPuesto(1, "Gerente", "McDonalds", "3 anios de experiencia como minimo.", listaItems);
		
		//Creo consultor
		GestorDeConsultor gestorConsultor = GestorDeConsultor.getInstance();
		gestorConsultor.createConsultor("TomasDannunzio", "Ramona123");
		
		//Creo candidato
		Calendar calendario = Calendar.getInstance();
		calendario.set(2000, 11, 3);
		Date fechaNacimiento = calendario.getTime();
		GestorDeCandidato gestorCandidato = GestorDeCandidato.getInstance();
		gestorCandidato.createCandidato(42870674, null, "DNI", 1, "Tomas", "Dannunzio", fechaNacimiento, "Argentina", "tomidannunzio@gmail.com", "Universitario", false);
		*/
		
		launch(args);
		
	}
}

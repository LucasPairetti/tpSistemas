package entidades;

import jakarta.persistence.*;

@Entity
public class RespuestaEnCuestionario {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="idRespuestaEnCuestionario")
	private int idRespuestaEnCuestionario;
	@Column(nullable = false)
	private String descripcion;
	@Column(nullable = false)
	private int ordenDeVisualizacion;
	
	public RespuestaEnCuestionario() {
		super();
	}
	
	public RespuestaEnCuestionario(Respuesta respuesta) {
		super();
		this.descripcion = respuesta.getDescripcion();
		this.ordenDeVisualizacion = respuesta.getOrdenDeVisualizacion();
	}

	public int getIdRespuestaEnCuestionario() {
		return idRespuestaEnCuestionario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getOrdenDeVisualizacion() {
		return ordenDeVisualizacion;
	}

	public void setOrdenDeVisualizacion(int ordenDeVisualizacion) {
		this.ordenDeVisualizacion = ordenDeVisualizacion;
	}
	
	
}

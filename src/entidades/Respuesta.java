package entidades;

import jakarta.persistence.*;

@Entity
public class Respuesta {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="idRespuesta")
	private int idRespuesta;
	@Column(nullable = false)
	private String descripcion;
	@Column(nullable = false)
	private int ordenDeVisualizacion;
	
	public Respuesta() {
		super();
	}
	
	public Respuesta(String descripcion, int ordenDeVisualizacion) {
		super();
		this.descripcion = descripcion;
		this.ordenDeVisualizacion = ordenDeVisualizacion;
	}

	public int getIdRespuesta() {
		return idRespuesta;
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

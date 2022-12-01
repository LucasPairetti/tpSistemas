package entidades;

public class Respuesta {
	private int idRespuesta;
	private String descripcion;
	private int ordenDeVisualizacion;
	
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

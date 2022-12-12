package DTOS;

public class RespuestaEnCuestionarioDTO {

	
	private int idRespuestaEnCuestionario;
	private String descripcion;
	private int ordenDeVisualizacion;
	
	
	public RespuestaEnCuestionarioDTO() {
		super();
	}


	public RespuestaEnCuestionarioDTO(String descripcion, int ordenDeVisualizacion) {
		super();
		this.descripcion = descripcion;
		this.ordenDeVisualizacion = ordenDeVisualizacion;
	}


	public int getIdRespuestaEnCuestionario() {
		return idRespuestaEnCuestionario;
	}


	public void setIdRespuestaEnCuestionario(int idRespuestaEnCuestionario) {
		this.idRespuestaEnCuestionario = idRespuestaEnCuestionario;
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

package entidades;

public class PonderacionRespuesta {
	private int idPonderacionRespuesta;
	private int ponderacion;
	private Respuesta respuesta;
	
	public PonderacionRespuesta(int ponderacion, Respuesta respuesta) {
		super();
		this.ponderacion = ponderacion;
		this.respuesta = respuesta;
	}
	
	public int getIdPonderacionRespuesta() {
		return idPonderacionRespuesta;
	}

	public int getPonderacion() {
		return ponderacion;
	}
	public void setPonderacion(int ponderacion) {
		this.ponderacion = ponderacion;
	}
	public Respuesta getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(Respuesta respuesta) {
		this.respuesta = respuesta;
	}
	
}

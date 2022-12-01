package entidades;

import java.util.Date;

public class Estado {
	private int idEstado;
	private Date fecha;
	private String Estado;
	private Cuestionario cuestionario;
	
	public Estado(Date fecha, String estado, Cuestionario cuestionario) {
		super();
		this.fecha = fecha;
		Estado = estado;
		this.cuestionario = cuestionario;
	}
	
	public int getIdEstado() {
		return idEstado;
	}

	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public Cuestionario getCuestionario() {
		return cuestionario;
	}
	public void setCuestionario(Cuestionario cuestionario) {
		this.cuestionario = cuestionario;
	}
}

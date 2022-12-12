package DTOS;

import java.util.Date;
import java.util.List;

import entidades.Cuestionario;
import entidades.Puesto;

public class EvaluacionDTO {
	
	private int idEvaluacion;

	private String estado;
	
	private Date fechaInicio;
	
	private Date fechaFin;
	
	private List<Cuestionario> cuestionarios;
	
	private Puesto puesto;

	public EvaluacionDTO() {
		super();
	}

	public EvaluacionDTO(String estado, Date fechaInicio, Date fechaFin, List<Cuestionario> cuestionarios,
			Puesto puesto) {
		super();
		this.estado = estado;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.cuestionarios = cuestionarios;
		this.puesto = puesto;
	}

	public int getIdEvaluacion() {
		return idEvaluacion;
	}

	public void setIdEvaluacion(int idEvaluacion) {
		this.idEvaluacion = idEvaluacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date date) {
		this.fechaInicio = date;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public List<Cuestionario> getCuestionarios() {
		return cuestionarios;
	}

	public void setCuestionarios(List<Cuestionario> cuestionarios) {
		this.cuestionarios = cuestionarios;
	}

	public Puesto getPuesto() {
		return puesto;
	}

	public void setPuesto(Puesto puesto) {
		this.puesto = puesto;
	}
	
	
	
}

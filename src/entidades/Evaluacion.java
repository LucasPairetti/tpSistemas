package entidades;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Evaluacion {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="idEvaluacion")
    private int idEvaluacion;
	@Column(nullable = false, unique = false)
    private String estado;
	@Column(nullable = false)
    private Date fechaInicio;
	@Column(nullable = true)
    private Date fechaFin;
	@OneToMany
	@JoinColumn(name="evaluacion_id", nullable = true, referencedColumnName="idEvaluacion", 
	foreignKey=@ForeignKey(name="FK_Evaluacion_Cuestionario", value=ConstraintMode.CONSTRAINT))
    private List<Cuestionario> cuestionarios;
	@ManyToOne
	@JoinColumn(name="puesto_id", nullable = false, referencedColumnName="idPuesto", 
	foreignKey=@ForeignKey(name="FK_Evaluacion_Puesto", value=ConstraintMode.CONSTRAINT))
    private Puesto puesto;

    public Evaluacion() {
        super();
    }

    public Evaluacion(String estado, Date fechaInicio, Date fechaFin, 
    		List<Cuestionario> cuestionarios, Puesto puesto) {
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

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
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
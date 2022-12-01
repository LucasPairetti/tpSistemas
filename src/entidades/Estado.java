package entidades;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Estado {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="idEstado")
	private int idEstado;
	@Column(nullable = false)
	private Date fecha;
	@Column(nullable = false)
	private String tipoEstado;
	@OneToOne
	@JoinColumn(name="idEstado", nullable = false, referencedColumnName="idEstado" , 
				foreignKey=@ForeignKey(name="FK_Estado_Cuestionario", value=ConstraintMode.CONSTRAINT))
	private Cuestionario cuestionario;
	
	public Estado() {
		super();
	}
	
	public Estado(Date fecha, String estado, Cuestionario cuestionario) {
		super();
		this.fecha = fecha;
		tipoEstado = estado;
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
		return tipoEstado;
	}
	public void setEstado(String estado) {
		tipoEstado = estado;
	}
	public Cuestionario getCuestionario() {
		return cuestionario;
	}
	public void setCuestionario(Cuestionario cuestionario) {
		this.cuestionario = cuestionario;
	}
}

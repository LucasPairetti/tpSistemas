package entidades;

import java.util.Date;
import jakarta.persistence.*;

@Entity
public class Auditoria {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="idAuditoria")
	private int idAuditoria;
	private Date fecha;
	@ManyToOne
	private Consultor consultor;
	
	public int getIdAuditoria() {
		return idAuditoria;
	}
	
	public Auditoria() {
		super();
	}
	
	public Auditoria(int idAuditoria, Date fecha, Consultor consultor) {
		super();
		this.idAuditoria = idAuditoria;
		this.fecha = fecha;
		this.consultor = consultor;
	}

	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Consultor getConsultor() {
		return consultor;
	}
	public void setConsultor(Consultor consultor) {
		this.consultor = consultor;
	}
}

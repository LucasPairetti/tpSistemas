package entidades;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Bloque {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="idBloque")
	private int idBloque;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	//@JoinColumn(name="bloque_id", nullable = false, referencedColumnName="idBloque" , 
	//foreignKey=@ForeignKey(name="FK_Bloque_PreguntaEnCuestionario", value=ConstraintMode.CONSTRAINT))
	private List<PreguntaEnCuestionario> preguntas;
	@Column(nullable = false)
	private int numeroBloque;
	@Column(nullable = false)
	private boolean completado;
	
	public Bloque() {
		super();
	}
	
	public Bloque(List<PreguntaEnCuestionario> preguntas, int numeroBloque, boolean completado) {
		super();
		this.preguntas = preguntas;
		this.numeroBloque = numeroBloque;
		this.completado = completado;
	}

	public int getIdBloque() {
		return idBloque;
	}

	public List<PreguntaEnCuestionario> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<PreguntaEnCuestionario> preguntas) {
		this.preguntas = preguntas;
	}

	public int getNumeroBloque() {
		return numeroBloque;
	}

	public void setNumeroBloque(int numeroBloque) {
		this.numeroBloque = numeroBloque;
	}
	
	
}

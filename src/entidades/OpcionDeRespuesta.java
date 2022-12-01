package entidades;

import java.util.List;
import jakarta.persistence.*;

@Entity
public class OpcionDeRespuesta {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="idOpcionDeRespuesta")
	private int idOpcionDeRespuesta;
	@Column(nullable= false, unique= true)
	private String nombre;
	@Column(nullable= false, unique= false)
	private String descripcion;
	@OneToMany
	@JoinColumn(name="opcionDeRespuesta_id", nullable = false, referencedColumnName="idOpcionDeRespuesta" , 
				foreignKey=@ForeignKey(name="FK_Opcion_Respuesta", value=ConstraintMode.CONSTRAINT))
	private List<Respuesta> listaRespuestas;
	
	public OpcionDeRespuesta() {
		super();
	}
	
	public OpcionDeRespuesta(String nombre, String descripcion, List<Respuesta> listaRespuestas) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.listaRespuestas = listaRespuestas;
	}

	public int getIdOpcionDeRespuesta() {
		return idOpcionDeRespuesta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Respuesta> getListaRespuestas() {
		return listaRespuestas;
	}

	public void setListaRespuestas(List<Respuesta> listaRespuestas) {
		this.listaRespuestas = listaRespuestas;
	}
	
}

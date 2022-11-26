package entidades;

import java.util.List;
import java.util.Objects;
import jakarta.persistence.*;

@Entity
public class Consultor {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="idConsultor")
	private int idConsultor;
	@Column(nullable = false, unique = true)
	private String nombreDeUsuario;
	@Column(nullable = false)
	private String constrasenia;
	
	public Consultor(String nombreDeUsuario, String constrasenia) {
		super();
		this.nombreDeUsuario = nombreDeUsuario;
		this.constrasenia = constrasenia;
	}

	public String getNombreDeUsuario() {
		return nombreDeUsuario;
	}

	public void setNombreDeUsuario(String nombreDeUsuario) {
		this.nombreDeUsuario = nombreDeUsuario;
	}

	public String getConstrasenia() {
		return constrasenia;
	}

	public void setConstrasenia(String constrasenia) {
		this.constrasenia = constrasenia;
	}
	
}
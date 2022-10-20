package entidades;

public class Competencia {
	private int idCompetencia;
	private int codigo;
	private String nombreCompetencia;
	private String descripcion;
	
	
	
	public Competencia() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Competencia(int idCompetencia, int codigo, String nombreCompetencia, String descripcion) {
		super();
		this.idCompetencia = idCompetencia;
		this.codigo = codigo;
		this.nombreCompetencia = nombreCompetencia;
		this.descripcion = descripcion;
	}



	public int getIdCompetencia() {
		return idCompetencia;
	}



	public void setIdCompetencia(int idCompetencia) {
		this.idCompetencia = idCompetencia;
	}



	public int getCodigo() {
		return codigo;
	}



	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}



	public String getNombreCompetencia() {
		return nombreCompetencia;
	}



	public void setNombreCompetencia(String nombreCompetencia) {
		this.nombreCompetencia = nombreCompetencia;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
	
	
}

package entidades;

public class ItemCompetencia {

	private Competencia competencia;
	private int ponderacion;
	
	
	
	public ItemCompetencia(Competencia competencia, int ponderacion) {
		super();
		this.competencia = competencia;
		this.ponderacion = ponderacion;
	}
	public Competencia getCompetencia() {
		return competencia;
	}
	public void setCompetencia(Competencia competencia) {
		this.competencia = competencia;
	}
	public int getPonderacion() {
		return ponderacion;
	}
	public void setPonderacion(int ponderacion) {
		this.ponderacion = ponderacion;
	}
	
}

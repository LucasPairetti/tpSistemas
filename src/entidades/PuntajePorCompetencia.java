package entidades;

public class PuntajePorCompetencia {
	private int idPuntajePorCompetencia;
	private int puntaje;
	private Competencia competencia;
	
	public PuntajePorCompetencia(int puntaje, Competencia competencia) {
		super();
		this.puntaje = puntaje;
		this.competencia = competencia;
	}
	public int getIdPuntajePorCompetencia() {
		return idPuntajePorCompetencia;
	}

	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	public Competencia getCompetencia() {
		return competencia;
	}
	public void setCompetencia(Competencia competencia) {
		this.competencia = competencia;
	}
	
}

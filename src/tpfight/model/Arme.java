package tpfight.model;

public class Arme implements IButin {
	private String nom;
	private int ptsActionMin;
	private int ptsDegat;

	public Arme(String nom, int ptsActionMin, int ptsDegat) {
		this.nom = nom;
		this.ptsActionMin = ptsActionMin;
		this.ptsDegat = ptsDegat;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}	
	public int getPtsActionMin() {
		return ptsActionMin;
	}
	public void setPtsActionMin(int ptsActionMin) {
		this.ptsActionMin = ptsActionMin;
	}
	public int getPtsDegat() {
		return ptsDegat;
	}
	public void setPtsDegat(int ptsDegat) {
		this.ptsDegat = ptsDegat;
	}
	
	public void distribuerButin() {
		
	}
}

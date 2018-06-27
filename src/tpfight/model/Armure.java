package tpfight.model;

public class Armure implements IButin{
	private String nom;
	private int ptsArmure;
	
	public Armure(String nom, int ptsArmure) {
		this.nom = nom;
		this.ptsArmure = ptsArmure;
		
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getPtsArmure() {
		return ptsArmure;
	}
	public void setPtsArmure(int ptsArmure) {
		this.ptsArmure = ptsArmure;
	}
}

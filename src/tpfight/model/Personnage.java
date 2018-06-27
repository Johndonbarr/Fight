package tpfight.model;

public class Personnage {
	private String nom;
	private int ptsVie;
	private int ptsAction;

	private Arme arme;
	private Armure armure;
	
	public Personnage(String nom, int ptsVie, int ptsAction, Arme arme, Armure armure) {
		super();
		this.nom = nom;
		this.ptsVie = ptsVie;
		this.ptsAction = ptsAction;
		this.arme = arme;
		this.armure = armure;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getPtsVie() {
		return ptsVie;
	}
	public void setPtsVie(int ptsVie) {
		this.ptsVie = ptsVie;
	}
	
	public int getPtsAction() {
		return ptsAction;
	}
	public void setPtsAction(int ptsAction) {
		this.ptsAction = ptsAction;
	}
	
	public Arme getArme() {
		return arme;
	}
	public void setArme(Arme arme) {
		this.arme = arme;
	}
	
	public Armure getArmure() {
		return armure;
	}
	public void setArmure(Armure armure) {
		this.armure = armure;
	}
}

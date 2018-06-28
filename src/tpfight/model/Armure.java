package tpfight.model;

public abstract class Armure implements IButin, IStatable {
	
	protected static final String STATS = "%d défense %s";
	
	private String nom;
	private int ptsArmure;
	
	public Armure() {
		
	}
	
	public Armure(int ptsArmure) {
		this.ptsArmure = ptsArmure;
	}
	
	public Armure(String nom, int ptsArmure) {
		this(ptsArmure);
		this.nom = nom;
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

	public abstract int receptionAttaque(Arme arme);
	
}

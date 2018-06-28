package tpfight.model;

public abstract class Arme implements IButin, IStatable {
	
	protected static final String STATS = "%d dégât d'attaque %s";
	
	private String nom;
	private int ptsActionMin;
	private int ptsDegat;

	public Arme() {
		
	}
	
	public Arme(int ptsActionMin, int ptsDegat) {
		this.ptsActionMin = ptsActionMin;
		this.ptsDegat = ptsDegat;
	}
	
	public Arme(String nom, int ptsActionMin, int ptsDegat) {
		this(ptsActionMin, ptsDegat);
		this.nom = nom;
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
	
	public int attaque(Armure armure) {
		int result = 0;

		result = this.getPtsDegat() - armure.getPtsArmure();

		return result > 0 ? result : 0;
	}
	
  }

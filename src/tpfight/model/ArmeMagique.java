package tpfight.model;

public class ArmeMagique extends Arme {
	int ptsMagie;
	
	public ArmeMagique(String nom, int ptsActionMin, int ptsDegat, int ptsMagie) {
		super(nom, ptsActionMin, ptsDegat);
		this.ptsMagie = ptsMagie;
	}
	
	public int getPtsMagie() {
		return this.ptsMagie;
	}
	public void setPtsMagie(int ptsMagie) {
		this.ptsMagie = ptsMagie;
	}
}

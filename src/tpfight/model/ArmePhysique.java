package tpfight.model;

public class ArmePhysique extends Arme {
	int ptsPhysique;
	
	public ArmePhysique(String nom, int ptsActionMin, int ptsDegat, int ptsPhysique) {
		super(nom, ptsActionMin, ptsDegat);
		this.ptsPhysique = ptsPhysique;
	}

	public int getPtsPhysique() {
		return this.ptsPhysique;
	}
	public void setPtsPhysique(int ptsMagie) {
		this.ptsPhysique = ptsMagie;
	}
	
}

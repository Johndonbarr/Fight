package tpfight.model;

public class ArmeMixte extends Arme {
	int ptsMagie;
	int ptsPhysique;
	
	public ArmeMixte(String nom, int ptsActionMin, int ptsDegat, int ptsMagie, int ptsPhysique) {
		super(nom, ptsActionMin, ptsDegat);
		this.ptsMagie = ptsMagie;
		this.ptsPhysique = ptsPhysique;
	}

	
	
}

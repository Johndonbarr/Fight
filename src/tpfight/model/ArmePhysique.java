package tpfight.model;

public class ArmePhysique extends Arme {
	
	public final static String TYPE = "physique";
	
	public ArmePhysique() {
		
	}

	public ArmePhysique(int ptsActionMin, int ptsDegat) {
		super(ptsActionMin, ptsDegat);
	}
	
	public ArmePhysique(String nom, int ptsActionMin, int ptsDegat) {
		super(nom, ptsActionMin, ptsDegat);
	}

	@Override
	public String getStats() {
		return String.format(STATS, getPtsDegat(), TYPE);
	}
	
	@Override
	public int attaque(Armure armure) {
		int result = 0;
		
		if (armure instanceof ArmurePhysique) {
			result = this.getPtsDegat() - armure.getPtsArmure();
		}else if(armure instanceof ArmureMixte){
			result = this.getPtsDegat() - ((ArmureMixte)armure).getArmurePhysique().getPtsArmure();
		}else{
			result = this.getPtsDegat();
		}
		
		return result > 0 ? result : 0;
	}
}

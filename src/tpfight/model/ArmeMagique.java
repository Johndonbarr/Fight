package tpfight.model;

public class ArmeMagique extends Arme implements IStatable {
	
	public final static String TYPE = "magique";
	
	public ArmeMagique() {
		
	}
	
	public ArmeMagique(int ptsActionMin, int ptsDegat) {
		super(ptsActionMin, ptsDegat);
	}
	
	public ArmeMagique(String nom, int ptsActionMin, int ptsDegat) {
		super(nom, ptsActionMin, ptsDegat);
	}
	
	@Override
	public String getStats() {
		return String.format(STATS, getPtsDegat(), TYPE);
	}
	
	@Override
	public int attaque(Armure armure) {
		int result = 0;
		
		if (armure instanceof ArmureMagique) {
			result = this.getPtsDegat() - armure.getPtsArmure();
		}else if(armure instanceof ArmureMixte){
			result = this.getPtsDegat() - ((ArmureMixte)armure).getArmureMagique().getPtsArmure();
		}else{
			result = this.getPtsDegat();
		}
		
		return result > 0 ? result : 0;
	}
}

package tpfight.model;

public class ArmeMixte extends Arme {
	private ArmePhysique armePhysique;
	private ArmeMagique armeMagique;
	
	public ArmeMixte(ArmePhysique armePhysique, ArmeMagique armeMagique) {
		this.armePhysique = armePhysique;
		this.armeMagique = armeMagique;
	}
	
	public ArmePhysique getArmePhysique() {
		return armePhysique;
	}
	public void setArmePhysique(ArmePhysique armePhysique) {
		this.armePhysique = armePhysique;
	}
	
	public ArmeMagique getArmeMagique() {
		return armeMagique;
	}
	public void setArmeMagique(ArmeMagique armeMagique) {
		this.armeMagique = armeMagique;
	}

	@Override
	public int attaque(Armure armure) {
		int result = 0;
		if (armure instanceof ArmureMixte) {
			result = (this.getArmeMagique().getPtsDegat() - ((ArmureMixte)armure).getArmureMagique().getPtsArmure())+
					(this.getArmePhysique().getPtsDegat() - ((ArmureMixte)armure).getArmurePhysique().getPtsArmure());
		}else if (armure instanceof ArmurePhysique) {
			result = (this.getArmeMagique().getPtsDegat())+
					(this.getArmePhysique().getPtsDegat() - armure.getPtsArmure());
		}else if (armure instanceof ArmureMagique) {
			result = (this.getArmeMagique().getPtsDegat() - armure.getPtsArmure())+
					(this.getArmePhysique().getPtsDegat());
		}
		return result > 0 ? result : 0;
	}
	
	@Override
	public String getStats() {
		return String.format(STATS, this.getArmeMagique().getPtsDegat(), ArmeMagique.TYPE, this.getArmePhysique().getPtsDegat(), ArmePhysique.TYPE);
	}
}

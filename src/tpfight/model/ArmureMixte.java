package tpfight.model;

public class ArmureMixte extends Armure {
	private ArmureMagique armureMagique;
	private ArmurePhysique armurePhysique;
	
	public ArmureMixte(ArmureMagique armureMagique, ArmurePhysique armurePhysique) {
		super();
		this.armureMagique = armureMagique;
		this.armurePhysique = armurePhysique;
	}
	
	public ArmureMixte(String nom, ArmureMagique armureMagique, ArmurePhysique armurePhysique) {
		this(armureMagique, armurePhysique);
		super.setNom(nom);
	}

	public ArmureMagique getArmureMagique() {
		return armureMagique;
	}
	public void setArmureMagique(ArmureMagique armureMagique) {
		this.armureMagique = armureMagique;
	}

	public ArmurePhysique getArmurePhysique() {
		return armurePhysique;
	}
	public void setArmurePhysique(ArmurePhysique armurePhysique) {
		this.armurePhysique = armurePhysique;
	}

	@Override
	public int receptionAttaque(Arme arme) {
		return 0;
	}

	@Override
	public String getStats() {
		return String.format(STATS, this.getArmureMagique().getPtsArmure(), ArmureMagique.TYPE, this.getArmurePhysique().getPtsArmure(), ArmurePhysique.TYPE);
	}
}

package tpfight.model;

public class ArmurePhysique extends Armure {
	
	public static final String TYPE = "physique";

	public ArmurePhysique() {
		
	}
	
	public ArmurePhysique(int ptsArmure) {
		super(ptsArmure);
	}
	
	public ArmurePhysique(String nom, int ptsArmure) {
		this(ptsArmure);
		super.setNom(nom);
	}

	@Override
	public int receptionAttaque(Arme arme) {
		return 0;
	}

	@Override
	public String getStats() {
		return String.format(STATS, getPtsArmure(), TYPE);
	}
}

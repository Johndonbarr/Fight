package tpfight.model;

public class ArmureMagique extends Armure {
	
	public static final String TYPE = "magique";

	public ArmureMagique() {
		
	}
	
	public ArmureMagique(int ptsArmure) {
		super(ptsArmure);
	}
	
	public ArmureMagique(String nom, int ptsArmure) {
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

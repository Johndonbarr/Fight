package tpfight.model.rpg.defaulttype;

import tpfight.model.Arme;
import tpfight.model.Armure;
import tpfight.model.Personnage;
import tpfight.model.rpg.TypePersonnage;

public class DefaultFighter implements TypePersonnage {
private static final String RESTRICTION = "sans restriction";
	
	private Personnage personnage;
	
	public Personnage getPersonnage() {
		return personnage;
	}

	public void setPersonnage(Personnage personnage) {
		this.personnage = personnage;
	}

	@Override
	public void fight(Personnage defender) {
		if (this.getPersonnage().getCharacteristic().getLife() > 0) {
			int damage = this.getPersonnage().getArme().attaque(defender.getArmure());
			defender.getCharacteristic().setLife(defender.getCharacteristic().getLife() - damage);
			System.out.println(String.format(TypePersonnage.ATTACK, this.getPersonnage().getNom(), damage, defender.getNom(), defender.getCharacteristic().getLife()));
		}
	}

	@Override
	public boolean isEquipable(Arme arme) {
		return true;
	}

	@Override
	public boolean isEquipable(Armure armure) {
		return true;
	}

	@Override
	public String getArmorRestriction() {
		return RESTRICTION;
	}

	@Override
	public String getWeaponRestriction() {
		return RESTRICTION;
	}
}

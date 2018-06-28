package tpfight.model.rpg.defaulttype;

import tpfight.model.Arme;
import tpfight.model.ArmeMagique;
import tpfight.model.Armure;
import tpfight.model.ArmureMagique;
//import tpfight.model.Personnage;
import tpfight.model.rpg.TypePersonnage;
import tpfight.model.rpg.Mage;

public class DefaultMage extends DefaultFighter implements Mage {
	@Override
	public boolean isEquipable(Arme arme) {
		boolean result = false;
		if (arme instanceof ArmeMagique) {
			result = true;
		}
		return result;
	}

	@Override
	public boolean isEquipable(Armure armure) {
		boolean result = false;
		if (armure instanceof ArmureMagique) {
			result = true;
		}
		return result;
	}
	
	@Override
	public String getArmorRestriction() {
		return String.format(TypePersonnage.EQUIPARMOR, Mage.CLASSE, Mage.EQUIPARMOR);
	}

	@Override
	public String getWeaponRestriction() {
		return String.format(TypePersonnage.EQUIPWEAPON, Mage.CLASSE, Mage.EQUIPWEAPON);
	}
}

package tpfight.model.rpg.defaulttype;

import tpfight.model.Arme;
import tpfight.model.ArmeMagique;
import tpfight.model.ArmeMixte;
import tpfight.model.Armure;
import tpfight.model.ArmureMagique;
import tpfight.model.ArmureMixte;
import tpfight.model.rpg.TypePersonnage;
import tpfight.model.rpg.Paladin;

public class DefaultPaladin extends DefaultFighter implements Paladin {
	@Override
	public boolean isEquipable(Arme arme) {
		boolean result = false;
		if (arme instanceof ArmeMixte || arme instanceof ArmeMagique) {
			result = true;
		}
		return result;
	}

	@Override
	public boolean isEquipable(Armure armure) {
		boolean result = false;
		if (armure instanceof ArmureMixte || armure instanceof ArmureMagique) {
			result = true;
		}
		return result;
	}
	
	@Override
	public String getArmorRestriction() {
		return String.format(TypePersonnage.EQUIPARMOR, Paladin.CLASSE, Paladin.EQUIPARMOR);
	}

	@Override
	public String getWeaponRestriction() {
		return String.format(TypePersonnage.EQUIPWEAPON, Paladin.CLASSE, Paladin.EQUIPWEAPON);
	}
}

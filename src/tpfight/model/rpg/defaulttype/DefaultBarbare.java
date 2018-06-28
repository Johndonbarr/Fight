package tpfight.model.rpg.defaulttype;

import tpfight.model.Arme;
import tpfight.model.ArmePhysique;
import tpfight.model.Armure;
import tpfight.model.ArmurePhysique;
import tpfight.model.Personnage;
import tpfight.model.rpg.Barbare;
import tpfight.model.rpg.TypePersonnage;

public class DefaultBarbare extends DefaultFighter implements Barbare {
	
	private final static String EQUIPWEAPON = "%s s'equipe d'une arme %s avec %s";
	
	private Arme secondaryWeapon;

	@Override
	public void setSecondaryWeapon(Arme secondaryWeapon) {
		if (this.isEquipable(secondaryWeapon)) {
			this.secondaryWeapon = secondaryWeapon;
			this.getPersonnage().getArme().setPtsDegat((this.getPersonnage().getArme().getPtsActionMin()+this.getSecondaryWeapon().getPtsDegat())/2);
			System.out.println(String.format(EQUIPWEAPON,this.getPersonnage().getNom(), secondaryWeapon.getClass().getSimpleName(),secondaryWeapon.getStats()));
		}else{
			System.out.println(this.getWeaponRestriction());
		}
	}

	@Override
	public Arme getSecondaryWeapon() {
		return this.secondaryWeapon;
	}
	
	@Override
	public void fight(Personnage defender) {
		if (this.getPersonnage().getCharacteristic().getLife() > 0) {
			int damage = this.getPersonnage().getArme().attaque(defender.getArmure()) + this.getSecondaryWeapon().getPtsDegat();
			defender.getCharacteristic().setLife(defender.getCharacteristic().getLife() - damage);
			System.out.println(String.format(TypePersonnage.ATTACK, this.getPersonnage().getNom(), damage, defender.getNom(), defender.getCharacteristic().getLife()));
		}
	}

	@Override
	public boolean isEquipable(Arme arme) {
		boolean result = false;
		if (arme instanceof ArmePhysique) {
			result = true;
		}
		return result;
	}

	@Override
	public boolean isEquipable(Armure armure) {
		boolean result = false;
		if (armure instanceof ArmurePhysique) {
			result = true;
		}
		return result;
	}

	@Override
	public String getArmorRestriction() {
		return String.format(TypePersonnage.EQUIPARMOR, Barbare.CLASSE, Barbare.EQUIPARMOR);
	}

	@Override
	public String getWeaponRestriction() {
		return String.format(TypePersonnage.EQUIPWEAPON, Barbare.CLASSE, Barbare.EQUIPWEAPON);
	}
}

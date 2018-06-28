package tpfight.model.rpg;

import tpfight.model.Arme;
import tpfight.model.Armure;
import tpfight.model.Personnage;

public interface TypePersonnage {
	public final static String ATTACK = "Le personnage %s inflige %d point de degats au personnage %s, il lui reste %d pv.";
	public final static String EQUIPWEAPON = "Un %s ne peut pas s'equiper d'une arme autre que %s.";
	public final static String EQUIPARMOR = "Un %s ne peut pas s'equiper d'une armure autre que %s.";
	public final static String CLASSE = "classe";
	
	void setPersonnage(Personnage personnage);
	
	String getArmorRestriction();
	
	String getWeaponRestriction();
	
	void fight(Personnage defender);

	boolean isEquipable(Arme arme);

	boolean isEquipable(Armure armure);
}

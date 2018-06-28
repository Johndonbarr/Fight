package tpfight.model.rpg;

import tpfight.model.Arme;

public interface Barbare {
	public final static String EQUIPWEAPON = "physique";
	public final static String EQUIPARMOR = "physique";
	public final static String CLASSE = "barbare";

	void setSecondaryWeapon(Arme arme);
	
	Arme getSecondaryWeapon();
}

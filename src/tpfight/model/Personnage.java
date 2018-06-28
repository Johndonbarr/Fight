package tpfight.model;

import java.util.ArrayList;
import java.util.List;

import tpfight.model.rpg.TypePersonnage;

public abstract class Personnage {
	private final static String EQUIPWEAPON = "%s s'equipe d'une arme %s avec %s";
	private final static String EQUIPARMOR = "%s s'equipe d'une armure %s avec %s";
	
	private String nom;
	Characteristic characteristic;
	private Arme arme;
	private Armure armure;
	private TypePersonnage typePersonnage;
	private List<IButin> butins;

	public Personnage() {
		this.setButins(new ArrayList<IButin>());
	}
	
	public Personnage(TypePersonnage typePersonnage) {
		this();
		this.typePersonnage = typePersonnage;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Characteristic getCharacteristic() {
		return characteristic;
	}
	public void setCharacteristic(Characteristic characteristic) {
		this.characteristic = characteristic;
	}
	
	public Arme getArme() {
		return arme;
	}
	public void setArme(Arme arme) {
		if (this.getTypePersonnage().isEquipable(arme)) {
			this.arme = arme;
			System.out.println(String.format(EQUIPWEAPON,this.getNom(), arme.getClass().getSimpleName(), arme.getStats()));
		}else{
			System.out.println(this.getTypePersonnage().getWeaponRestriction());
		}
	}
	
	public Armure getArmure() {
		return armure;
	}
	public void setArmure(Armure armure) {
		this.armure = armure;
	}
	
	public TypePersonnage getTypePersonnage() {
		return typePersonnage;
	}
	public void setTypePersonnage(TypePersonnage typePersonnage) {
		this.typePersonnage = typePersonnage;
	}

	public List<IButin> getButins() {
		return butins;
	}
	public void setButins(List<IButin> butins) {
		this.butins = butins;
	}
}

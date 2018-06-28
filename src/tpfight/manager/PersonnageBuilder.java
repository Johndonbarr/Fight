package tpfight.manager;

import java.util.ArrayList;
import java.util.List;

import tpfight.model.Arme;
import tpfight.model.ArmeMagique;
import tpfight.model.ArmeMixte;
import tpfight.model.ArmePhysique;
import tpfight.model.Armure;
import tpfight.model.ArmureMagique;
import tpfight.model.ArmureMixte;
import tpfight.model.ArmurePhysique;
import tpfight.model.IButin;
import tpfight.model.Characteristic;
import tpfight.model.Heros;
import tpfight.model.Mob;
import tpfight.model.Personnage;
import tpfight.model.rpg.Barbare;
import tpfight.model.rpg.TypePersonnage;
import tpfight.model.rpg.Mage;
import tpfight.model.rpg.Paladin;
import tpfight.model.rpg.defaulttype.DefaultFighter;

public class PersonnageBuilder {
	private Personnage personnage;
	private TypePersonnage typePersonnage;
	private Arme arme;
	private Armure armure;
	private String name;
	private Characteristic characteristic;
	private List<IButin> butins;

	public PersonnageBuilder() {
		this.butins = new ArrayList<IButin>();
	}

	public PersonnageBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public PersonnageBuilder setCharacteristic(Characteristic characteristic) {
		this.characteristic = characteristic;
		return this;
	}

	public PersonnageBuilder setButins(List<IButin> butins) {
		this.butins = butins;
		return this;
	}

	public PersonnageBuilder setPersonnageType(Personnage personnage) {
		this.personnage = personnage;
		return this;
	}

	public PersonnageBuilder setClasse(TypePersonnage typePersonnage) {
		this.typePersonnage = typePersonnage;
		return this;
	}

	/////////////////////// Defaults ////////////////////////////
	
	public PersonnageBuilder setDefaultCharacteristic(){
		this.characteristic = new Characteristic(23, 8);
		return this;
	}
	
	public PersonnageBuilder setDefaultEquipment(){
		if (this.personnage.getTypePersonnage() instanceof Barbare) {
			this.arme = new ArmePhysique(3, 2);
			this.armure = new ArmurePhysique(2);
		}else if (this.personnage.getTypePersonnage() instanceof Mage) {
			this.arme = new ArmeMagique(3, 2);
			this.armure = new ArmureMagique(2);
		}else if (this.personnage.getTypePersonnage() instanceof Paladin) {
			this.arme = new ArmeMixte(new ArmePhysique(2, 1),new ArmeMagique(2, 2));
			this.armure = new ArmureMixte(new ArmureMagique(2),new ArmurePhysique(2));
		}else{
			this.arme = new ArmePhysique(3, 2);
			this.armure = new ArmurePhysique(2);
		}
		return this;
	}
	
	public PersonnageBuilder setDefaultHero(TypePersonnage typePersonnage){
		this.personnage = new Heros();
		this.typePersonnage = typePersonnage;
		this.personnage.setTypePersonnage(typePersonnage);
		setDefaultCharacteristic();
		setDefaultEquipment();
		return this;
	}

	public Personnage build() {
		if (personnage == null) {
			personnage = new Mob();
		}
		
		if (typePersonnage == null) {
			typePersonnage = new DefaultFighter();
		}
		
		if (arme == null) {
			arme = new ArmePhysique(1,2);
		}
		
		if (armure == null) {
			armure = new ArmurePhysique(0);
		}
		
		if (characteristic == null) {
			characteristic = new Characteristic(5,2);
		}
		
		if (name == null || name.equals("")) {
			name = "unamed";
		}
		
		if (butins.isEmpty() && personnage != null && personnage instanceof Mob) {
			butins = LootGenerator.generateLoots();
		}

		this.personnage.setTypePersonnage(typePersonnage);
		this.personnage.getTypePersonnage().setPersonnage(personnage);
		this.personnage.setArme(arme);
		this.personnage.setArmure(armure);
		this.personnage.setNom(name);
		this.personnage.setCharacteristic(characteristic);
		this.personnage.setButins(butins);
		
		return personnage;
	}
}

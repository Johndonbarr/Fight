package tpfight;

import java.util.ArrayList;

import tpfight.manager.Combat;
import tpfight.manager.PersonnageBuilder;
import tpfight.model.ArmeMagique;
import tpfight.model.ArmeMixte;
import tpfight.model.ArmePhysique;
import tpfight.model.ArmureMagique;
import tpfight.model.ArmureMixte;
import tpfight.model.ArmurePhysique;
import tpfight.model.Heros;
import tpfight.model.Mob;
import tpfight.model.Personnage;
import tpfight.model.rpg.Barbare;
import tpfight.model.rpg.defaulttype.DefaultBarbare;
import tpfight.model.rpg.defaulttype.DefaultFighter;
import tpfight.model.rpg.defaulttype.DefaultMage;
import tpfight.model.rpg.defaulttype.DefaultPaladin;

public class TP17 {
	public static void main(String[] args) {
		PersonnageBuilder builder = new PersonnageBuilder();

		Personnage paladin = builder.setName("paladin").setDefaultHero(new DefaultPaladin()).build();
		builder = new PersonnageBuilder();

		Personnage barbare = builder.setName("barbare").setDefaultHero(new DefaultBarbare()).build();
		((Barbare) barbare.getTypePersonnage()).setSecondaryWeapon(new ArmePhysique(2, 3));
		builder = new PersonnageBuilder();

		Personnage mage = builder.setName("mage").setDefaultHero(new DefaultMage()).build();
		builder = new PersonnageBuilder();

		Personnage mob1 = builder.setName("mob1").build();
		builder = new PersonnageBuilder();

		Personnage mob2 = builder.setName("mob2").build();
		builder = new PersonnageBuilder();

		Personnage mob3 = builder.setName("mob3").build();
		builder = new PersonnageBuilder();

		Combat combat = new Combat(new ArrayList<Personnage>() {
			{
				add(paladin);
				add(barbare);
				add(mage);
			}
		}, new ArrayList<Personnage>() {
			{
				add(mob1);
				add(mob2);
				add(mob3);
			}
		});
		combat.fightNoBack();
	}

}

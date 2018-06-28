package tpfight;

import java.sql.SQLException;
import java.util.ArrayList;

import database.DBManager;
import database.DBOpenHelper;
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
		//DBOpenHelper.getInstance()...
		// --> Retourne toujours la même instance (unique).
		DBOpenHelper.getInstance();
		
		//System.out.println(new DBManager().request("SHOW TABLES"));
		//System.out.println(new DBManager().request("INSERT INTO role (name) VALUES ('machin')")); pas bon !
		//System.out.println(new DBManager().updateRequest("INSERT INTO role (name) VALUES ('machin')"));
		DBManager dbm = new DBManager();

		int numRole = 0;
		int numUser = 0;
		
		int nbRoles = 3;
		int nbUsers = 20;
		
		// Ajout d'éléments "role".
		int[] tab_roles = new int[nbRoles];
		for (int i = 0; i < tab_roles.length; i++) {
			tab_roles[i] = dbm.updateRequest("INSERT INTO role (name) VALUES ('role" + i + "')");
			System.out.println("Rôle " + i + " inséré. Valeur de retour : " + tab_roles[i]);
		}
		/*
		// Ajout d'éléments "user".
		for (int i = 0; i < tab_roles.length; i++) {
			for (int j = 0; j < 2; j++) {
				dbm.updateRequest("INSERT INTO user (name, id_Role) VALUES ('user" + i + "-" + j + "', " + tab_roles[i] + ")");
				System.out.println("User " + i + "-" + j + " inséré. Valeur de retour : " + tab_roles[i]);
			}
		}
		*/
		// Ajout d'éléments "user" sans id_Role.
		for (int i = 0; i < nbUsers; i++) {
			numUser++;
			String userName = "user" + numUser;
			int valeurRetour = dbm.updateRequest("INSERT INTO user (name) VALUES ('" + userName + "')");
			System.out.println(userName + " inséré. Valeur de retour : " + valeurRetour);
		}
		// Ajout d'éléments "role".
		for (int i = 0; i < nbRoles; i++) {
			numRole++;
			String roleName = "role" + numRole;
			int valeurRetour = dbm.updateRequest("INSERT INTO role (name) VALUES ('" + roleName + "')");
			System.out.println(roleName + " inséré. Valeur de retour : " + valeurRetour);
		}
		
		// Ajout des éléments "user".
		/*
		for (int i = 0; i < nbUsers; i++) {
			numUser++;
			String userName = "user" + numUser;
			int valeurRetour = dbm.updateRequest("INSERT INTO user (name) VALUES ('" + userName + "')");
			System.out.println(userName + " inséré. Valeur de retour : " + valeurRetour);
		}
		*/
		// Ajout des éléments "role".

		
		//setUp();
	
		try {
			DBOpenHelper.getInstance().getConn().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void setUp() {
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

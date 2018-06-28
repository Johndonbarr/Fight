package tpfight.manager;

import java.util.List;

import tpfight.model.Personnage;

public class Combat {
	private static final String ROUND_NB = "Tour %d :";
	private static final String FIGHT_START = "Début du combat entre %s et %s";
	private static final String CHARACTER_ALIVE = "le personnage %s est encore vivant avec %d points de vie ";
	private static final String CHARACTER_DIED = "le personnage %s est mort ";
	private final static String FIGHT_ENDED = "Le combat est fini : \n\téquipe1 : %s\n\téquipe2 : %s";

	private List<Personnage> attackers;
	private List<Personnage> defenders;

	public Combat(List<Personnage> attackers, List<Personnage> defenders) {
		super();
		this.attackers = attackers;
		this.defenders = defenders;
	}
	
	public void fightNoBack(){
		while (teamAlive(attackers)&&teamAlive(defenders)) {
			fight();
		}
	}

	public void fight() {
		setUp(attackers);
		setUp(defenders);

		int round = 1;
		System.out.println(String.format(FIGHT_START, showTeams(attackers), showTeams(defenders)));

		Personnage attacker = null;
		Personnage defender = null;
		while ((attacker = findNextAliveCharacter(attackers,attacker)) != null
				&& (defender = findNextAliveCharacter(defenders,defender)) != null
				) {
			System.out.println(String.format(ROUND_NB, round));
			round(attacker, defender);
			round(defender, attacker);
			round++;
		}

		System.out
				.println(String.format(FIGHT_ENDED, showCharactersResult(attackers), showCharactersResult(defenders)));
	}
	
	private boolean teamAlive(List<Personnage> personnages){
		boolean result = false;
		
		for (Personnage personnage : personnages) {
			if (personnage.getCharacteristic().getLife()>0) {
				result = true;
			}
		}
		
		return result;
	}

	private Personnage findNextAliveCharacter(List<Personnage> personnages, Personnage lastPersonnage) {
		Personnage result = null;

		for (Personnage personnage : personnages) {
			if (personnage.getCharacteristic().getLife() > 0 && personnage.getCharacteristic().getCurrentActionPoint() - personnage.getArme().getPtsActionMin() >= 0 && !personnage.equals(lastPersonnage)) {
				result = personnage;
				break;
			}
		}
		
		if (result == null && lastPersonnage.getCharacteristic().getLife() > 0 && lastPersonnage.getCharacteristic().getCurrentActionPoint() - lastPersonnage.getArme().getPtsActionMin() >= 0) {
			result = lastPersonnage;
		}

		return result;
	}

	private void setUp(List<Personnage> personnages) {
		for (Personnage personnage : personnages) {
			personnage.getCharacteristic().setCurrentActionPoint(personnage.getCharacteristic().getActionPoint());
		}
	}

	private String showTeams(List<Personnage> personnages) {
		StringBuilder result = new StringBuilder();

		for (Personnage personnage : personnages) {
			result.append(personnage.getNom() + " ");
		}

		return result.toString();
	}

	private String showCharactersResult(List<Personnage> personnages) {
		StringBuilder result = new StringBuilder();

		for (Personnage personnage : personnages) {
			if (personnage.getCharacteristic().getLife() <= 0) {
				result.append(String.format(CHARACTER_DIED, personnage.getNom()));
			} else {
				result.append(String.format(CHARACTER_ALIVE, personnage.getNom(), personnage.getCharacteristic().getLife()));
			}
		}

		return result.toString();
	}

	private void round(Personnage attacker, Personnage defender) {
		if (attacker.getCharacteristic().getCurrentActionPoint() - attacker.getArme().getPtsDegat() >= 0) {
			attacker.getCharacteristic().setCurrentActionPoint(attacker.getCharacteristic().getCurrentActionPoint() - attacker.getArme().getPtsDegat());
			attacker.getTypePersonnage().fight(defender);
		}
	}
}

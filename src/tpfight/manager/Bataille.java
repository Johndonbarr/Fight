package tpfight.manager;

import java.util.Scanner;

import tpfight.model.Arme;
import tpfight.model.Armure;
import tpfight.model.Personnage;

public class Bataille {
	private static Scanner sc = new Scanner(System.in);
	private Personnage[] joueurs;
	
	private static final String GAGNE = "%s inflige %d dégâts à %s, il reste %d vie à %s.";
	private static final String INEFFICACE = "%s n'arrive pas à faire des dégâts à %s.";
	private static final String FINJEU = "Le joueur %s gagne le match.";
	
	/**
	 * Constructeur permettant l'initialisation par l'utilisateur du jeu
	 */
	public Bataille() {
		super(); // ?

		int joueurs = 0;
		do {
			System.out.println("Combien de joueurs?");
			joueurs = sc.nextInt();
		} while (joueurs < 2);
		this.joueurs = new Personnage[joueurs];

		// Test avec données de l'énnoncé
		this.joueurs = new Personnage[3];
		this.joueurs[0] = new Personnage("Bob", 9, 7, new Arme("Pelle", 1, 2), new Armure("GiletBleu", 1));
		//this.joueurs[0] = new Personnage(9, 7, new Arme(ArmeType.Pelle), new Armure(ArmureType.GiletBleu), "perso1");
		//this.joueurs[1] = new Personnage(4, 12, new Arme(ArmeType.Blaster), new Armure(ArmureType.ArmureDeCuir),
				"perso2");
		//this.joueurs[2] = new Personnage(15, 8, new Arme(ArmeType.Concasseur), new Armure(ArmureType.ArmureDePlaque),
				"perso3");

		// Action utilisateur pour définir les personnages
		// for (int i = 0; i < this.joueurs.length; i++) {
		// this.joueurs[i] = selectionPerso(i+1);
		// }
	}
	
	// Fonction principale permettant de combattre
	public void combattre() {
		boolean notEnded = true;
		while (notEnded) {
			for (int i = 0; notEnded && i < joueurs.length; i++) {
				if (joueurs[i].getPtsVie() > 0) {
					Personnage defenseur = trouverDefenseur(i);
					if (defenseur == null) {
						combatSuccessMessage(joueurs[i]);
						notEnded = false;
					} else {
						combat(joueurs[i], defenseur);
					}
				}
			}
		}
	}
	
	/**
	 * Affiche la fin de jeu avec le gagnant
	 * 
	 * @param personnage
	 *            (gagnant)
	 */
	private void combatSuccessMessage(Personnage personnage) {
		System.out.println(String.format(FINJEU, personnage.getNom()));
	}
	
	/**
	 * Permet de trouver le prochain défenseur.
	 * 
	 * @param attaquant
	 *            (entier représentant le joueur courant)
	 * @return null si aucun défenseur trouvé ou le prochain défenseur
	 */
	private Personnage trouverDefenseur(int attaquant) {
		int i = attaquant;
		Personnage defenseur = null;

		// Boucle tant que l'on n'est pas revenu au départ
		boolean flag = true;
		do {
			// Vérification de l'indice pour ne pas sortir du tableau
			if (i + 1 == joueurs.length) {
				i = 0;
			} else {
				i++;
			}

			if (joueurs[i].getPtsVie() > 0) {
				defenseur = joueurs[i];
				flag = false;
			}
		} while (flag && i != attaquant);

		// Retourne le défenseur suivant ou null si la partie est finie
		return defenseur;
	}
	
	/**
	 * Combat entre 2 personnages
	 * 
	 * @param attaquant
	 * @param defenseur
	 */
	public void combat(Personnage attaquant, Personnage defenseur) {
		int pa = attaquant.getPtsAction();
		// L'attaquant s'équipe de l'arme.
		pa--;
		while (pa - attaquant.getArme().getPtsActionMin() > 0) {
			pa -= attaquant.getArme().getPtsActionMin();
			if (attaquant.getArme().getPtsDegat() - defenseur.getArmure().getPtsArmure() > 0) {
				defenseur.setPtsVie(
						defenseur.getPtsVie() - (attaquant.getArme().getPtsDegat() - defenseur.getArmure().getPtsArmure()));
				fightSuccessMessage(attaquant, defenseur);
				if (defenseur.getPtsVie() <= 0) {
					return;
				}
			} else {
				fightLoseMessage(attaquant, defenseur);
			}
		}
		
	}
	
	/**
	 * Affichage si des points de vie sont enlevés
	 * 
	 * @param attaquant
	 * @param defenseur
	 */
	public void fightSuccessMessage(Personnage attaquant, Personnage defenseur) {
		System.out.println(String.format(GAGNE, attaquant.getNom(),
				attaquant.getArme().getPtsDegat() - defenseur.getArmure().getPtsArmure(), defenseur.getNom(),
				defenseur.getPtsVie(), defenseur.getNom()));
	}
	
	/**
	 * Affichage si aucun point de vie n'a été enlevé
	 * 
	 * @param attaquant
	 * @param defenseur
	 */
	public void fightLoseMessage(Personnage attaquant, Personnage defenseur) {
		System.out.println(String.format(INEFFICACE, attaquant.getNom(), defenseur.getNom()));
	}
}

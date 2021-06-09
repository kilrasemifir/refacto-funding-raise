package kira.formation.refactor.funding.raised;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represente une table contenant un ensemble de données.
 * @author Killian
 *
 */
public class TableDonnee {

	private List<String[]> donnees;
	private String[] entetes;
	
	public TableDonnee(List<String[]> donnees, String[] entetes) {
		super();
		this.donnees = donnees;
		this.entetes = entetes;
	}
	
	/**
	 * Retourne l'id de la colonne en fonction de son nom
	 * @param nomColonne
	 * @return
	 */
	public int getColonneId(String nomColonne) {
		for (int id=0; id<entetes.length; id++) {
			if (entetes[id].equals(nomColonne)) {
				return id;
			}
		}
		throw new RuntimeException("Aucune colonne ne porte le nom "+nomColonne);
	}

	/**
	 * Filtre les lignes de la table en fonction de la valeur pour la colonne portant le nom nomColonne
	 * @param nomColonne nom de la colonne ou filtrer
	 * @param valeur de filtrage
	 * @return nouvelle TableDonnee ayant uniquement les valeurs filtre.
	 */
	public TableDonnee filtre(String nomColonne, String valeur) {
		int idColonne = this.getColonneId(nomColonne);
		List<String[]> donneeFiltre = new ArrayList<String[]>();
		for(String[] ligne: this.donnees) {
			if (ligne[idColonne].equals(valeur)) {
				donneeFiltre.add(ligne);
			}
		}
		return new TableDonnee(donneeFiltre, entetes);
	}
	
	/**
	 * Transforme la table au format List<Map<String,String>>.
	 * @return
	 */
	public List<Map<String, String>> toListMap() {
		List<Map<String, String>> output = new ArrayList<Map<String, String>>();
        for(String[] ligne: this.donnees) {
            output.add(ligneToMap(ligne));
        }
        return output;
	}
	
	/**
	 * Transforme une ligne en Map<String, String>.
	 * @param ligne
	 * @return
	 */
	private Map<String, String> ligneToMap(String[] ligne) {
		Map<String, String> mapped = new HashMap<String, String> ();
		int i = 0;
		for(String nomColonne: this.entetes) {
			mapped.put(nomColonne, ligne[i]);
			i++;
		}
		return mapped;
	}
}

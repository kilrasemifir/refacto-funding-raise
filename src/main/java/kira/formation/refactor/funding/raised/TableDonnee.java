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

	public TableDonnee filtre(String nomColonne, String valeur) {
		// TODO
		return null;
	}
	
	public List<Map<String, String>> toListMap() {
		List<Map<String, String>> output = new ArrayList<Map<String, String>>();

        for(int i = 0; i < donnees.size(); i++) {
            Map<String, String> mapped = new HashMap<String, String> ();
            insertRowsInMap(donnees, i, mapped);
            output.add(mapped);
        }

        return output;
	}
	
	private void insertRowsInMap(List<String[]> csvData, int i, Map<String, String> mapped) {
		mapped.put("permalink", csvData.get(i)[0]);
		mapped.put("company_name", csvData.get(i)[1]);
		mapped.put("number_employees", csvData.get(i)[2]);
		mapped.put("category", csvData.get(i)[3]);
		mapped.put("city", csvData.get(i)[4]);
		mapped.put("state", csvData.get(i)[5]);
		mapped.put("funded_date", csvData.get(i)[6]);
		mapped.put("raised_amount", csvData.get(i)[7]);
		mapped.put("raised_currency", csvData.get(i)[8]);
		mapped.put("round", csvData.get(i)[9]);
	}
}

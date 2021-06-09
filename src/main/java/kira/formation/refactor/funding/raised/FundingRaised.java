package kira.formation.refactor.funding.raised;

import java.util.*;
import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FundingRaised {
	/**
	 * Filtre les donn�es du csv en fonction des options de recherche pass� en parametre.
	 * @param optionsFiltrage
	 * @return
	 * @throws IOException
	 */
    public static List<Map<String, String>> filtrageDuCSV(Map<String, String> optionsFiltrage, String filePath, TableReader reader) throws IOException {
        TableDonnee data = reader.read(filePath);
        data = filtre(optionsFiltrage, data);
        return data.toListMap();
    }
    
    /**
     * Filtre les lignes de ma table de donn�e pour ne garder uniquement 
     * celle respectant les options pass� dans la map options filtrage
     * @param optionsFiltrage
     * @param data
     */
    private static TableDonnee filtre(Map<String, String> optionsFiltrage, TableDonnee data) {
    	for (String nomColonne : optionsFiltrage.keySet()) {
			data = data.filtre(nomColonne, optionsFiltrage.get(nomColonne));
		}
    	return data;
    }
    
    public static void main(String[] args) {
        try {
            Map<String, String> optionsFiltrage = new HashMap<String, String> ();
            optionsFiltrage.put("company_name", "Facebook");
            optionsFiltrage.put("round", "a");
            String filePath = "startup_funding.csv";
			System.out.print(FundingRaised.filtrageDuCSV(optionsFiltrage, filePath, new CSVTableReader()).size());
        } catch(IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        }
    }
}

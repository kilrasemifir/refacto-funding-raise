package kira.formation.refactor.funding.raised;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class CSVTableReader implements TableReader{

	public TableDonnee read(String filePath) throws IOException {
		List<String[]> csvData = new ArrayList<String[]>();
		CSVReader reader = new CSVReader(new FileReader(filePath));
        String[] row = null;
        while((row = reader.readNext()) != null) {
            csvData.add(row);
        }
        reader.close();
        String[] entete = csvData.get(0);
        csvData.remove(0);
        return new TableDonnee(csvData, entete);
	}

}

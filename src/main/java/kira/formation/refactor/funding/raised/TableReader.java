package kira.formation.refactor.funding.raised;

import java.io.IOException;

public interface TableReader {

	public TableDonnee read(String filePath) throws IOException;
}

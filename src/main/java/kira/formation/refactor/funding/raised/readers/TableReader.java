package kira.formation.refactor.funding.raised.readers;

import java.io.IOException;

import kira.formation.refactor.funding.raised.TableDonnee;

public interface TableReader {

	/**
	 * Récupere des données depuis une source.
	 * @param filePath chemin vers la source de donnée, par exemple un fichier.
	 * @return une table de donnée.
	 * @throws IOException
	 */
	public TableDonnee read(String filePath) throws IOException;
}

package kira.formation.refactor.funding.raised.readers;

import java.io.IOException;

import kira.formation.refactor.funding.raised.TableDonnee;

public interface TableReader {

	/**
	 * R�cupere des donn�es depuis une source.
	 * @param filePath chemin vers la source de donn�e, par exemple un fichier.
	 * @return une table de donn�e.
	 * @throws IOException
	 */
	public TableDonnee read(String filePath) throws IOException;
}

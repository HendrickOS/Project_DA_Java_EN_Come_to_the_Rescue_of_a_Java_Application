package com.hemebiotech.analytics;

public class AnalyticsCounter {

	private String symptomsFilePath, resultFileName;

	/**
	 * @param symptomsFilePath le fichier de d�part contenant la liste des
	 *                         symptomes, non tri�s et sans leur nombre d'occurrence
	 * @param resultFileName   le fichier final contenant liste des symptomes,
	 *                         tri�s, ainsi que leur nombre d'occurence
	 */
	public AnalyticsCounter(String symptomsFilePath, String resultFileName) {
		this.symptomsFilePath = symptomsFilePath;
		this.resultFileName = resultFileName;
	}

	public void proceed() {
		// Instanciation
		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile(symptomsFilePath);

		// R�cup�ration du Dictionnaire (symptomes, occurrence)
		readSymptomDataFromFile.getSymptoms();

		// R�cup�ration du fichier listant les symptomes par ordre alphab�tique et de
		// leur occurrence
		readSymptomDataFromFile.saveResult(resultFileName);

	}
}

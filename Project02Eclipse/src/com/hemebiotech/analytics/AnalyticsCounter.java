package com.hemebiotech.analytics;

public class AnalyticsCounter {

	private String symptomsFilePath, resultFileName;

	/**
	 * @param symptomsFilePath le fichier de départ contenant la liste des
	 *                         symptomes, non triés et sans leur nombre d'occurrence
	 * @param resultFileName   le fichier final contenant liste des symptomes,
	 *                         triés, ainsi que leur nombre d'occurence
	 */
	public AnalyticsCounter(String symptomsFilePath, String resultFileName) {
		this.symptomsFilePath = symptomsFilePath;
		this.resultFileName = resultFileName;
	}

	public void proceed() {
		// Instanciation
		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile(symptomsFilePath);

		// Récupération du Dictionnaire (symptomes, occurrence)
		readSymptomDataFromFile.getSymptoms();

		// Récupération du fichier listant les symptomes par ordre alphabétique et de
		// leur occurrence
		readSymptomDataFromFile.saveResult(resultFileName);

	}
}

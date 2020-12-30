package com.hemebiotech.analytics;

public class AnalyticsCounter {

	private String symptomsFilePath, resultFileName;

	public AnalyticsCounter(String symptomsFilePath, String resultFileName) {
		this.symptomsFilePath = symptomsFilePath;
		this.resultFileName = resultFileName;
	}

	public void proceed() {
		// Instanciation
		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile(symptomsFilePath);
		readSymptomDataFromFile.getSymptoms();
		// Ecrire les résultats dans un fichier
		readSymptomDataFromFile.saveResult(resultFileName);

	}
}

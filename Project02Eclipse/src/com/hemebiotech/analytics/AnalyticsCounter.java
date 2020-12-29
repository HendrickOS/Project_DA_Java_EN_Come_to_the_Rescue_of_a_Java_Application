package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AnalyticsCounter {
	private static int headacheCount = 0; // initialize to 0
	private static int rashCount = 0; // initialize to 0
	private static int pupilCount = 0; // initialize to 0

	// Cr�ation d'un dictionnaire (Cl�[nom du symptome], Valeur[nombre d'occurence
	// du symptome])
	static Map<String, Integer> mapSymptom = new HashMap<String, Integer>();

	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader(new FileReader("Project02Eclipse/symptoms.txt"));
		String line = reader.readLine();

		if (line == null) {
			System.out.println("Votre liste de symptomes est vide");
		}

		int actualValue;

		while (line != null) {
			if (mapSymptom.containsKey(line)) {
				actualValue = mapSymptom.get(line);
				actualValue++;
				mapSymptom.put(line, actualValue);
			}

			else {
				mapSymptom.put(line, 1);
			}

			line = reader.readLine(); // get another symptom
		}

		// Ecrire les r�sultats dans un fichier
		FileWriter writer = new FileWriter("result.out");

		// Affichage du dictionnaire
		System.out.println("Affichage des cl�s, valeurs de notre dictionnaire : ");
		Iterator iterator = mapSymptom.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry mapentry = (Map.Entry) iterator.next();
			System.out.println("cl� : " + mapentry.getKey() + " / valeur : " + mapentry.getValue());
			writer.write(mapentry.getKey() + " " + mapentry.getValue() + "\n"); // On �crit la cl� et sa valeur dans le
																				// fichier d�di�
		}
		writer.close(); // On ferme l'�diteur de fichier
	}
}

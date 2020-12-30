package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	static Map<String, Integer> mapSymptom = new HashMap<String, Integer>();

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public Map<String, Integer> getSymptoms() {
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filepath));
				String line = reader.readLine();
				int actualValue;

				while (line != null) {
					if (mapSymptom.containsKey(line)) {
						actualValue = mapSymptom.get(line);
						actualValue++;
						mapSymptom.put(line, actualValue);
					} else {
						mapSymptom.put(line, 1);
					}
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Erreur pendant la lecture du fichier : " + filepath);
			}
		}

		return mapSymptom;
	}

	public void saveResult(String resultFileName) {
		FileWriter writer;
		try {
			writer = new FileWriter(resultFileName);
			Map<String, Integer> triSymptom = new TreeMap<String, Integer>(mapSymptom); // Tri du dictionnaire avec
																						// TreeMap
			Set<?> set = triSymptom.entrySet();
			Iterator<?> iterator = set.iterator();
			while (iterator.hasNext()) {
				Map.Entry mapentry = (Map.Entry) iterator.next();
				writer.write(mapentry.getKey() + " " + mapentry.getValue() + "\n"); // On écrit la clé et sa valeur dans
																					// le
				// fichier dédié
			}
			writer.close(); // On ferme l'éditeur de fichier
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

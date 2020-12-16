package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
	private static int headacheCount = 0; // initialize to 0
	private static int rashCount = 0; // initialize to 0
	private static int pupilCount = 0; // initialize to 0

	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader(new FileReader("Project02Eclipse/symptoms.txt"));
		String line = reader.readLine();

		if (line == null) {
			System.out.println("Votre liste de symptomes est vide");
		}

		int i = 0;
		int headCount = headacheCount; // counts headaches
		int rashCount2 = rashCount; // counts rashes
		int pupilCount2 = pupilCount; // counts pupils

		// On parcourt la liste des symptômes
		while (line != null) {
			i++; // increment i
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++; // Si on trouve un headache, on ajoute 1 au compteur headache
			} else if (line.equals("rash")) {
				rashCount2++; // Si on trouve un rash, on ajoute 1 au compteur rash
			} else if (line.contains("pupils")) {
				pupilCount2++; // Si on trouve un pupil, on ajoute 1 au compteur pupil
			}
			line = reader.readLine(); // get another symptom
		}

		// On affiche les symptômes ainsi que leur nombre d'occurence
		System.out.println("number of headaches: " + headCount);
		System.out.println("number of rashes: " + rashCount2);
		System.out.println("number of pupils: " + pupilCount2);

		// next generate output
		FileWriter writer = new FileWriter("result.out");
		writer.write("headache: " + headCount + "\n");
		writer.write("rash: " + rashCount2 + "\n");
		writer.write("dialated pupils: " + pupilCount2 + "\n");
		writer.close();
	}
}

package com.hemebiotech.analytics;

public class Main {

	public static void main(String[] args) {
		String symptomsFilePath = "Project02Eclipse/symptoms.txt";
		String resultFileName = "results.out";
		AnalyticsCounter counter = new AnalyticsCounter(symptomsFilePath, resultFileName);
		counter.proceed();
	}
}

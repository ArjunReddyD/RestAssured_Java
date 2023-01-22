package com.qa.utils;

import java.io.FileReader;
import java.util.List;

import com.opencsv.CSVReaderBuilder;


public class CSV_Reader {

	public static String[] readCSVData(int testCaseId, String csvPath) throws Exception {
		
		
		FileReader filereader = new FileReader(csvPath);
		com.opencsv.CSVReader reader = new CSVReaderBuilder(filereader).build();
		List<String[]> readTestData = reader.readAll();
		String[] data = readTestData.get(testCaseId);
		
		return data;
	}
}

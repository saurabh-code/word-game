package com.bootcamp.word_game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bootcamp.word_game.interfaces.FileReader;


public class SowPodsReader implements FileReader {

	public List<String> fetchLinesFromFile(String pathToFile) throws FileNotFoundException {
		File file = new File(pathToFile);
		Scanner sc = new Scanner(file);
		
		List<String> words = new ArrayList<String>();
		
		while(sc.hasNextLine()) {
			String word = sc.nextLine();
			words.add(word);
		}
		
		return words;
	}
}

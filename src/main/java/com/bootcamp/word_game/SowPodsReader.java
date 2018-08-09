package com.bootcamp.word_game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
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
			if (word.length() == 5 && uniqueCharacters(word)) {
				words.add(word);
			}
		}
		
		return words;
	}
	
	boolean uniqueCharacters(String str)
    {
        char [] chArray = str.toCharArray();
        Arrays.sort(chArray);
 
        for(int i=0; i<chArray.length-1; i++)
        {
            if (chArray[i] != chArray[i+1])
                continue;
            else
                return false;
        }
        return true;
    }
	
}

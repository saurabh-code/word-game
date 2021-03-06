package com.bootcamp.word_game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class WordUtils {

	public static int countSimilarity(String fixedWord, String guessedWord) {
		List<String> fixedLetters = new ArrayList<>(Arrays.asList(fixedWord.split("")));
		List<String> guessedLetters = new ArrayList<>(Arrays.asList(guessedWord.split("")));
		
		int count = 0;
		for (String s: guessedLetters) {
			if (fixedLetters.contains(s)) {
				count++;
				fixedLetters.remove(fixedLetters.indexOf(s));
			}
		}
		return count;
	}
	
	public static boolean isWin(String fixedWord, String guessedWord) {
		return fixedWord.equals(guessedWord);
	}
	
	public static int countOfInvalidWordsToBeRemoved(List<String> dict, String guess, int similarity) {
		return (int) dict.parallelStream()
					.filter(s -> countSimilarity(guess, s) != similarity)
					.count();
	}

	public static List<String> removeInvalidWords(List<String> dict, String guess, int similarity) {
		return dict.parallelStream()
					.filter(s -> countSimilarity(guess, s) == similarity)
					.collect(Collectors.toList());
		}
}


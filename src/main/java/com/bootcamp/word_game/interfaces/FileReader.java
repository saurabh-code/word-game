package com.bootcamp.word_game.interfaces;

import java.io.FileNotFoundException;
import java.util.List;

public interface FileReader {

	public List<String> fetchLinesFromFile(String pathToFile, int size) throws FileNotFoundException;
}

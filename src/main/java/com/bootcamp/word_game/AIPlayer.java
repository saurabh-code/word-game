package com.bootcamp.word_game;

import com.bootcamp.word_game.interfaces.FileReader;
import com.bootcamp.word_game.interfaces.Player;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Random;

public class AIPlayer implements Player {

    private List<String> dict;
    private String hiddenWord;
    private static final String SOW_PODS = "src/resources/sowpods.txt";
    private KnuthSolver knuthSolver;

    AIPlayer(int difficulty){
        FileReader fileReader = new SowPodsReader();
        try {
            dict = fileReader.fetchLinesFromFile(SOW_PODS, difficulty);
            knuthSolver = new KnuthSolver(dict);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void chooseAWord() {
        Random rand = new Random();
        hiddenWord = dict.get(rand.nextInt(dict.size()));
    }

    @Override
    public String guessWord(int previousSimilarity) {
        return knuthSolver.next(previousSimilarity);
    }

    @Override
    public boolean isCorrectGuess(String guess) {
        return hiddenWord.equals(guess);
    }

    @Override
    public int getSimilarity(String guess) {
        return WordUtils.countSimilarity(hiddenWord, guess);
    }

    @Override
    public int getPlayerId() {
        return 0;
    }
}

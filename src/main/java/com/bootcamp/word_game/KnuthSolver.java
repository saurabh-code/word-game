package com.bootcamp.word_game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KnuthSolver {

    private List<String> possibleOutcomes;
    private String currentWord;

    KnuthSolver(List<String> possibleOutcomes){
        this.possibleOutcomes = possibleOutcomes;
    }

    private String selectBest(){

        int bestMinValue = Integer.MIN_VALUE;
        String bestWord = "";

        for(String s1 : possibleOutcomes){

            int minWordsEliminated = Integer.MAX_VALUE;


            for(String s2 : possibleOutcomes){
                int similarity = WordUtils.countSimilarity(s2, s1);
                int wordsEliminated = WordUtils.countOfInvalidWordsToBeRemoved(possibleOutcomes, s1, similarity);

                if(minWordsEliminated > wordsEliminated)
                    minWordsEliminated = wordsEliminated;

                if(minWordsEliminated <= bestMinValue)
                    break;
            }

            if(bestMinValue < minWordsEliminated){
                bestMinValue = minWordsEliminated;
                bestWord = s1;
            }

        }

        return bestWord;
    }


    private void pruneList(int similarity){
        possibleOutcomes = WordUtils.removeInvalidWords(possibleOutcomes, currentWord, similarity);
    }


    public String next(int guessSimilarity){
        if(currentWord == null){
            Random rand = new Random();
            currentWord = possibleOutcomes.get(rand.nextInt(possibleOutcomes.size()));
        }
        else {
            pruneList(guessSimilarity);
            possibleOutcomes.remove(currentWord);
            currentWord = selectBest();
        }
        return currentWord;
    }
}

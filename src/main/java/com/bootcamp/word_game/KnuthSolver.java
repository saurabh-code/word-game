package com.bootcamp.word_game;

import java.util.ArrayList;
import java.util.List;

public class KnuthSolver {

    List<String> possibleOutcomes = new ArrayList<>();

    private String selectBest(){

        int bestMinValue = Integer.MIN_VALUE;
        String bestWord = "";

        for(String s1 : possibleOutcomes){

            int minWordElimated = Integer.MAX_VALUE;


            for(String s2 : possibleOutcomes){
                int similarity = WordUtils.countSimilarity(s2, s1);
                int wordsEliminated = WordUtils.countOfInvalidWordsToBeRemoved(possibleOutcomes, s1, similarity);

                if(minWordElimated > wordsEliminated)
                    minWordElimated = wordsEliminated;
            }

            if(bestMinValue < minWordElimated){
                bestMinValue = minWordElimated;
                bestWord = s1;
            }

        }

        return bestWord;
    }

}

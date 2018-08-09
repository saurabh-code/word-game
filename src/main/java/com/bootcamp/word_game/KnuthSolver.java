package com.bootcamp.word_game;

import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;

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
            currentWord = makeRandomGuess(); 
        } else if (possibleOutcomes.size() >= 2000) {
        		currentWord = pruneAndSelect(() -> makeRandomGuess(), guessSimilarity);
        }
        else {
            currentWord = pruneAndSelect(() -> selectBest(), guessSimilarity);
        }
        return currentWord;
    }
    
    private String makeRandomGuess() {
    		Random rand = new Random();
        return possibleOutcomes.get(rand.nextInt(possibleOutcomes.size()));
    }
    
    private String pruneAndSelect(Supplier<String> nextWord, int guessSimilarity) {
    		pruneList(guessSimilarity);
        possibleOutcomes.remove(currentWord);
        return nextWord.get();
    }
}

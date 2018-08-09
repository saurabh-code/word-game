package com.bootcamp.word_game.interfaces;

public interface Player {

	public void chooseAWord();
	
	public String guessWord(int previousSimilarity);
	
	public boolean isCorrectGuess(String guess);
	
	public int getSimilarity(String guess);
	
	public int getPlayerId();
}

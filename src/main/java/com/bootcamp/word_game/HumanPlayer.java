package com.bootcamp.word_game;

import java.util.Scanner;

import com.bootcamp.word_game.interfaces.Player;

public class HumanPlayer implements Player {

	private String hiddenWord;
	private Scanner in = new Scanner(System.in);
	private int id;
	
	
	public HumanPlayer(int id) {
		this.id = id;
	}
	
	@Override
	public void chooseAWord() {
		System.out.print("Choose a hidden word => ");
		hiddenWord = in.nextLine();
	}

	@Override
	public String guessWord(int previousSimilarity) {
		System.out.print("Make a guess => ");
		return in.nextLine();
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
		return this.id;
	}
	
	
}

package com.bootcamp.word_game;

import com.bootcamp.word_game.interfaces.Player;

public class Driver {
	
	private Player playerOne;
	private Player playerTwo;

	public Driver(Player player1, Player player2) {
		this.playerOne = player1;
		this.playerTwo = player2;
	}
	
	public void playGame() {
		playerOne.chooseAWord();
		playerTwo.chooseAWord();
		
		int playerOneSimilarity = 0;
		int playerTwoSimilarity = 0;
		
		while (true) {
			String playerOneGuess = playerOne.guessWord(playerOneSimilarity);
			playerOneSimilarity = playerCheckGuess(playerTwo, playerOneGuess);
			
			if (hasMatchEnded(playerOneSimilarity)) break;
			
			String playerTwoGuess = playerTwo.guessWord(playerTwoSimilarity);
			playerTwoSimilarity = playerCheckGuess(playerOne, playerTwoGuess);
			
			if (hasMatchEnded(playerTwoSimilarity)) 	break;
		}
		
		System.out.println("Game Over");
	}
	
	private int playerCheckGuess(Player player, String guess) {
		int nextSimilarity = -1;
		if (player.isCorrectGuess(guess)) {
			System.out.println("Player " + player.getPlayerId() + " has won");
		} else {
			nextSimilarity = player.getSimilarity(guess);
			System.out.println("Player " + player.getPlayerId() + " says your guess has " + nextSimilarity + " letters common");
		}
		return nextSimilarity;
	}
	
	private boolean hasMatchEnded(int similarity) {
		return similarity == -1;
	}

}

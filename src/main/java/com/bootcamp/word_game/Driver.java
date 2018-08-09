package com.bootcamp.word_game;

import com.bootcamp.word_game.interfaces.Player;

public class Driver {
	
	private static final int MATCH_FOUND = -1;
	
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
			playerOneSimilarity = playerMakesGuess(playerOne, playerTwo, playerOneSimilarity);
			if (hasMatchEnded(playerOneSimilarity)) break;
			
			playerTwoSimilarity = playerMakesGuess(playerTwo, playerOne, playerTwoSimilarity);
			if (hasMatchEnded(playerTwoSimilarity)) 	break;
		}
		
		System.out.println("Game Over");
	}
	
	private int playerMakesGuess(Player player, Player opponent, int previousSimilarity) {
		String playerGuess = player.guessWord(previousSimilarity);
		System.out.println("Player " +
							player.getPlayerId() +
							" Guessed " + playerGuess);
		return playerCheckGuess(opponent, playerGuess);
	}
	
	private int playerCheckGuess(Player player, String guess) {
		int nextSimilarity = -1;
		if (player.isCorrectGuess(guess)) {
			System.out.println("Player " + 
								player.getPlayerId() + 
								" has won");
		} else {
			nextSimilarity = player.getSimilarity(guess);
			System.out.println("Player " + 
								player.getPlayerId() + 
								" says your guess has " + 
								nextSimilarity + 
								" letters common");
		}
		return nextSimilarity;
	}
	
	private boolean hasMatchEnded(int similarity) {
		return similarity == MATCH_FOUND;
	}

}

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
		
		String playerOneGuess = playerOne.guessWord(0);
		
		if (playerTwo.isCorrectGuess(playerOneGuess)) {
			System.out.println("Player 2 wins");
		} else {
			System.out.println("Player 2 says your guess has " + playerTwo.getSimilarity(playerOneGuess) + " letters common");
		}
		
		String playerTwoGuess = playerTwo.guessWord(0);
		
		if (playerOne.isCorrectGuess(playerTwoGuess)) {
			System.out.println("Player 1 wins");
		} else {
			System.out.println("Player 1 says your guess has " + playerTwo.getSimilarity(playerOneGuess) + " letters common");
		}
	}
	
//	private int playerMakesGuess(Player player, int similarity) {
//		String guess = player.guessWord(similarity);
//		int nextSimilarity = -1;
//		if (player.isCorrectGuess(guess)) {
//			System.out.println("Player " + player.getPlayerId() + " has won");
//		} else {
//			nextSimilarity = player.getSimilarity(guess);
//			System.out.println("Player ");
//		}
//	}

}

package com.bootcamp.word_game;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
//    		int difficulty = Integer.parseInt(args[0]);
    		int difficulty = 5;
        Driver driver = new Driver(new HumanPlayer(1), new AIPlayer(difficulty));
        driver.playGame();
    }
}

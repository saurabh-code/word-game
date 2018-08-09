package com.bootcamp.word_game;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Driver driver = new Driver(new HumanPlayer(1), new HumanPlayer(2));
        driver.playGame();
    }
}

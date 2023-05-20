package NumberGuessGame;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.io.*;
import GameFolder.*;
public class NumberGuessGame implements Game {
    
    public String getGameName() {
        return "NumberGuessGame";
    }

    // must be able to play a game

    public String getScore(int guess) {
        String b = Integer.toString(guess);
        return b; 
    } // get a score - if there is no "score" then we

    public void writeHighScore(File f) {

    } 

     // writes the high score of this game to a file.

    public void play(){
        try (Scanner in = new Scanner(System.in)) {
            int low, high;

            //Loop while valid range was not entered
            while (true){
                System.out.println("Please enter the lowest number of your range:");
                low = in.nextInt();
                System.out.println("Please enter the highest number of your range:");
                high = in.nextInt();
                
                if (high > low) break;
                else System.out.println("This aint in your range. Try again");
            }

            //Generate the random secret number in the range
            Random rnd = new Random();
            int secret = rnd.nextInt(high - low) + low;

            //Get the first guess 
            System.out.println("Please enter your enthusiastic guess ");
            int guess = in.nextInt();
            int numGuesses = 0;
            ArrayList<Integer> guesses= new ArrayList<>();
            guesses.add(guess);

            if (guess < low || guess > high)
                System.out.println("Your guess is out of range.");

            //Loop while user didn't guess the number
            while (guess != secret){
                if (secret < guess)
                    System.out.println("The number you are looking for is lower");
                else
                    System.out.println("The number you are looking for is higher");

                
                System.out.println("Please enter your guess: ");
                guess = in.nextInt();
                if (guess < low || guess > high)
                    System.out.println("Your guess is out of range.");
                
                //Check if this guess was made in the past
                if (guesses.indexOf(guess) != -1){
                    System.out.println("You already tried this number.");
                }
                else{
                    numGuesses++;
                    guesses.add(guess);
                }
            }

            //user guessed the secret number.
            if (guess == secret) {
                System.out.println("Congratulations, you won!!! You are super duper smart and took 85.5% less guesses than the average person who played this game.");
                System.out.println("You made only " + (numGuesses +1) + " guesses.");
            }
        }



    }

    @Override
    public String getScore() {
        // TODO Auto-generated method stub
        return null;
    }

}
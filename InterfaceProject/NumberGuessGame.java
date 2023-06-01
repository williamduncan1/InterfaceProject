/**
 * William Duncan
 * Date: 1/20/22
 * This program is a guessing game named "guess the super duper secret number" where you will guess the super duper secret number.
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class NumberGuessGame implements Game{

    int numGuesses;

    public NumberGuessGame(){
        numGuesses = 0;
    }
    
    public String getGameName(){
        return "Number Guess Game";
    }

    public String getScore(){
        return String.valueOf(numGuesses);
    }

    public void writeHighScore(File f){
        try (FileWriter fw = new FileWriter(f)) {
            fw.write(getGameName() + "," + getScore());
        }
        catch (Exception e){}

    }

    public void play(){
        Scanner in = new Scanner(System.in);
        int low, high;

        //Loop while valid range was not entered
        while (true){
            System.out.println("Please enter the lowest number of your range:");
            low = in.nextInt();
            System.out.println("Please enter the highest number of your range:");
            high = in.nextInt();
            
            if (high > low) break;
            else System.out.println("This is very sadly not in your range. Please try again.");
        }

        //Generate the random secret number in the range
        Random rnd = new Random();
        int secret = rnd.nextInt(high - low) + low;

        //Get the first guess 
        System.out.println("Please enter your very smart guess ");
        int guess = in.nextInt();
        numGuesses = 0;
        ArrayList<Integer> guesses= new ArrayList<>();
        guesses.add(guess);

        if (guess < low || guess > high)
            System.out.println("Your guess is out of range.");

        //Loop while user didn't guess the number
        while (guess != secret){
            if (secret < guess)
                System.out.println("The super duper secret number is lower.");
            else
                System.out.println("The super duper secret number is higher");

            
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
 



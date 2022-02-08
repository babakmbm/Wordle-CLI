package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String secretWord = "BOOK";
        String guess = "";
        int AttemptCount = 0;
        int AttemptLimit = 6;

        for(int i=1; i<=5; i++){
            if(!guess.toLowerCase().equals(secretWord.toLowerCase())){
                System.out.printf("Attempt-%d: \n", i);
                System.out.printf("Please type in your guess word: ");
                guess = input.nextLine();
                AttemptCount++;
            }else if(guess.toLowerCase().equals(secretWord.toLowerCase())){
                System.out.println("You are a Winner!");
                break;
            }
            if(AttemptCount == AttemptLimit && !guess.toLowerCase().equals(secretWord.toLowerCase())){
                System.out.println("Out of attempts!");
                System.out.println("You are a Loser!");
            }
        }


        // Model model = new Model();
        // model.read_words("All");
    }
}

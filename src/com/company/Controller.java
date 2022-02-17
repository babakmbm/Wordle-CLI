package com.company;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Controller {
    private String secret_word;
    private String guess_word;
    private Random randomGenerator;
    private Model model;
    private View view;


    public String getSecretWord(ArrayList<String> list){
        randomGenerator = new Random();
        int index = randomGenerator.nextInt(list.size());
        this.secret_word = list.get(index);
        //System.out.println("The secret word is: " + this.secret_word );
        return this.secret_word.toUpperCase();
    }

    public void create_board(){
        this.view = new View();
        this.view.print_board();
    }

    public void setGuess(){
        Scanner keyboardInput = new Scanner(System.in);
        while(true) {
            System.out.println("Please type a five letter word with no numbers: ");
            String guess;
            guess = keyboardInput.nextLine();
            if((guess.length() == 5) && (!guess.contains("[0-9]"))){
                this.guess_word = guess.toUpperCase();
                break;
            }else{
                continue;
            }
        }
    }

    public String getGuess(){
        return this.guess_word;
    }

    public void update_board(int attempt){
        System.out.println("Attempt Number:" + attempt);
        System.out.println();


        if (this.guess_word.length() == 5) {
            ArrayList<Character> guess_chars = new ArrayList<Character>();
            for (char c : this.guess_word.toCharArray()) {
                guess_chars.add(c);
            }
            // TODO: Check the characters one by one
            // TODO: If guess word contains any of the characters in the secret word find their position
            // TODO: If the word is available in the common words
            view.setBoard(guess_chars, attempt);
        }else{
            System.out.println("The guess word should be exactly 5 characters!");
        }
    }
}

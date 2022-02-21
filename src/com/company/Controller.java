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
        this.secret_word = list.get(index).toUpperCase();
        //System.out.println("The secret word is: " + this.secret_word );
        return this.secret_word;
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
            //String highlight_guess_word = view.printCompare(this.guess_word.toUpperCase(), this.secret_word.toUpperCase());
            ArrayList<Character> guess_chars = new ArrayList<Character>();
            for (char c : this.guess_word.toCharArray()) {
                guess_chars.add(c);
            }
            view.setBoard(guess_chars, attempt);
            this.compare_letters();
        }else{
            System.out.println("The guess word should be exactly 5 characters!");
        }
    }

    public void compare_letters(){
        int flag = 0; // 0 = contains but not in place// 1 = contains and in place// -1 = does not contain
        for (int n=0; n<guess_word.length(); n++){
            char nthChar = guess_word.charAt(n);
            if(n<secret_word.length() && nthChar == secret_word.charAt(n)){
                flag = 1;
                view.printMessage(flag, nthChar);
            }else if(secret_word.contains(String.valueOf(nthChar))){
                flag = 0;
                view.printMessage(flag, nthChar);
            }else {
                flag = -1;
                view.printMessage(flag, nthChar);
            }
        }
    }



}

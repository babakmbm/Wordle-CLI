package com.company;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Model model = new Model();
        Controller ctl = new Controller();

        ArrayList<String> all_words;
        all_words = model.read_words("Common");
        String secret_word = ctl.getSecretWord(all_words);
        System.out.println("\n");
        System.out.println("The Secret Word is: " + secret_word);
        ctl.create_board();
        for(int i=0; i<6; i++){
            ctl.setGuess();
            ctl.update_board(i);
        }
        //ctl.compare_letters();


    }
}

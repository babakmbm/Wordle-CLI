package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Controller {
    private String secret_word;
    private Random randomGenerator;

    public String getSecretWord(ArrayList<String> list){
        randomGenerator = new Random();
        int index = randomGenerator.nextInt(100);
        this.secret_word = list.get(index);
        // System.out.println("The secret word is: " + this.secret_word );
        return this.secret_word;
    }

    public void create_board(){
        View view = new View(this.secret_word);
        view.print_board();
    }

}

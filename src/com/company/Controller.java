package com.company;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Controller {
    private String secret_word;
    private String guess_word;
    private Random randomGenerator;
    private Model model;
    private View view;

    public ArrayList<String> load_word_dictionary(String filename){
        this.model = new Model();
        ArrayList<String> all_words = model.read_words(filename);
        this.secret_word = getSecretWord(all_words);
        return all_words;
    }

    public String getSecretWord(ArrayList<String> list){
        randomGenerator = new Random();
        int index = randomGenerator.nextInt(list.size());
        this.secret_word = list.get(index).toUpperCase();
        System.out.println("The secret word is: " + this.secret_word);
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

    public void update_board(){
        boolean win_flag=false;
        for(int attempt = 0; attempt <6; attempt++){
            this.setGuess();
            System.out.println();

            if (this.guess_word.length() == 5) {
                //String highlight_guess_word = view.printCompare(this.guess_word.toUpperCase(), this.secret_word.toUpperCase());
                ArrayList<Character> guess_chars = new ArrayList<Character>();
                for (char c : this.guess_word.toCharArray()) {
                    guess_chars.add(c);
                }
                view.setBoard(guess_chars, attempt);
                System.out.println("Attempt Number:" + (attempt+1));
                int correct_letters = this.compare_letters();
                if(correct_letters == 5){
                    view.winner(attempt);
                    win_flag = true;
                    break;
                }
            }else{
                System.out.println("The guess word should be exactly 5 characters!");
            }
        }
        if (!win_flag){
            view.loser();
        }
    }

    public int compare_letters(){
        int flag = 0; // 0 = contains but not in place// 1 = contains and in place// -1 = does not contain
        int correct_letters = 0;
        for (int n=0; n < guess_word.length(); n++){
            char nthChar = guess_word.charAt(n);
            if(n < this.secret_word.length() && nthChar == this.secret_word.charAt(n)){
                flag = 1;
                correct_letters ++;
                view.printMessage(flag, nthChar);
            }else if(secret_word.contains(String.valueOf(nthChar))){
                flag = 0;
                view.printMessage(flag, nthChar);
            }else {
                flag = -1;
                view.printMessage(flag, nthChar);
            }
        }
        return correct_letters;
    }



}

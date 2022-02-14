package com.company;

import java.util.ArrayList;

public class View {
    private Model model;
    private String s_word;
    private ArrayList<Character> secret_word = new ArrayList<Character>();
    private char board[][] = new char[6][5];

    public View(String word){
        this.s_word = word;
        this.create_board();
    }

    private void create_board() {
        for (char c : this.s_word.toCharArray()) {
            secret_word.add(c);
        }
        System.out.println(this.secret_word);

        for (int row=0; row<6; row++){
            for (int col=0; col<5; col++){
                this.board[row][col] = '-';
            }
        }
    }

    public void print_board(){
        for(int row=0; row<this.board.length; row++){
            for (int col=0; col<this.board[row].length; col++){
                System.out.print(this.board[row][col] + "    ");
            }
            System.out.println();
        }
    }

    public void update_board(String guess, int attempt){
        ArrayList<Character> guess_chars = new ArrayList<Character>();
        for (char c : guess.toCharArray()) {
            guess_chars.add(c);
        }
        for(int row=0; row<this.board.length; row++){
            for (int col=0; col<this.board[row].length; col++){
                System.out.print(this.board[row][col] + "    ");

            }
            System.out.println();
        }
    }

}

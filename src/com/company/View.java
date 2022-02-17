package com.company;

import java.util.ArrayList;

public class View {
    private Model model;
    private String s_word;
    private ArrayList<Character> secret_word = new ArrayList();
    private char board[][] = new char[6][5];

    public View(String word){
        this.s_word = word;
        this.create_board('*');
    }

    private void create_board(char filler) {
        for (char c : this.s_word.toCharArray()) {
            secret_word.add(c);
        }
        //System.out.println(this.secret_word);

        for (int row=0; row<6; row++){
            for (int col=0; col<5; col++){
                this.board[row][col] = filler;
            }
        }
    }

    public void print_board(){
        System.out.println();
        for(int row=0; row<this.board.length; row++){
            for (int col=0; col<this.board[row].length; col++){
                System.out.print(this.board[row][col] + "      ");
            }
            System.out.println();
            System.out.println();
        }
    }

    public char[][] getBoard(){
        return this.board;
    }

    public void setBoard(ArrayList<Character> guess_chars, int attempt){
        System.out.println(guess_chars);
        for (int i = 0; i < guess_chars.size(); i++) {
            this.board[attempt][i] = guess_chars.get(i);
        }
        this.print_board();
    }

    public void winner(){
        System.out.println("YOU WIN!");
        //System.out.println("YOU WON IN " + 5 + " attempts!");
    }

}

package com.company;

import java.util.ArrayList;

public class View {
    // for colors in the terminal
    private enum Color{
        BLACK("\033[0;30m"),    // BLACK
        RED("\033[0;31m"),      // RED
        GREEN("\033[0;32m"),    // GREEN
        YELLOW("\033[0;33m"),   // YELLOW
        BLUE("\033[0;34m"),     // BLUE
        MAGENTA("\033[0;35m"),  // MAGENTA
        CYAN("\033[0;36m"),     // CYAN
        WHITE("\033[0;37m");    // WHITE

        private final String ansi_background;
        private final static String ANSI_RESET = "\u001B[0m";

        private Color(String ansi_background){
            this.ansi_background = ansi_background;
        }
    }

    private static String highlight_text(String text, Color forHighlight){
        return forHighlight.ansi_background + text + Color.ANSI_RESET;
    }

    private char board[][] = new char[6][5];

    public View(){
        this.create_board();
    }

    private void create_board() {
        for (int row=0; row<6; row++){
            for (int col=0; col<5; col++){
                this.board[row][col] = '#';
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

    public void winner(int attempt){
        attempt = attempt+1;
        System.out.println();
        System.out.println("CONGRATULATIONS YOU WIN!");
        if(attempt==1) {
            System.out.println("YOU WON IN " + attempt + " attempt!");
        }else {
            System.out.println("YOU WON IN " + attempt + " attempts!");
        }
    }

    public void loser(){
        System.out.println("YOU Lose!");
        System.out.println("YOU are out of attempts!");
    }

    public String printWithColors(String guess_word, String secret_word) {
        String output = "";
        for (int n=0; n<guess_word.length(); n++){
            char nthChar = guess_word.charAt(n);
            if(n<secret_word.length() && nthChar == secret_word.charAt(n)){
                output += highlight_text(Character.toString(nthChar), Color.GREEN);
            }else if(secret_word.contains(String.valueOf(nthChar))){
                output += highlight_text(Character.toString(nthChar), Color.YELLOW);
            }else {
                output += nthChar;
            }

            if (n!= guess_word.length()-1){
                output += "*";
            }
        }
        return output;
    }

    public void printMessage(int flag, char nthChar){
        if (flag==1){
            System.out.println(nthChar + " In the right Place");
        }else if(flag == 0){
            System.out.println(nthChar + " Not In the right place");
        }else {
            System.out.println(nthChar + " Not Included in the secret word");
        }
    }
}

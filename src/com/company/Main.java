package com.company;

public class Main {

    public static void main(String[] args) {

        Controller ctl = new Controller();

        ctl.load_word_dictionary("Common");
        ctl.create_board();
        ctl.update_board();

    }
}

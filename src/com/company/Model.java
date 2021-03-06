package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import java.util.ArrayList;

public class Model {
    private String words_file = "src/com/company/words.txt";
    private String common_file = "src/com/company/common.txt";
    private String file_chosen;

    private ArrayList<String> all_words = new ArrayList<String>();


    public ArrayList<String> read_words(String file_name){
        if (file_name.toLowerCase().equals("all")){
            try {
                this.file_chosen = this.words_file;
                GetFileInfo();
                File myFile = new File(this.words_file);
                Scanner myReader = new Scanner(myFile);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    this.all_words.add(data);
                }
                System.out.println(all_words);
                myReader.close();
            } catch (FileNotFoundException e) {
                //System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }else if(file_name.toLowerCase().equals("common")) {
            try {
                this.file_chosen = this.common_file;

                File myFile = new File(this.common_file);
                Scanner myReader = new Scanner(myFile);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    this.all_words.add(data);
                }
                System.out.println("Common Words are chosen! \n");
                GetFileInfo();
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        else{
            System.out.println("Please choose the correct word file!");
            System.out.printf("[OPTIONS]: \n1. Common\n2. All");
        }
        return this.all_words;
    }

    public void GetFileInfo(){
        File myObj = new File(this.file_chosen);
        if (myObj.exists()) {
            System.out.println("File name: " + myObj.getName());
            System.out.println("Absolute path: " + myObj.getAbsolutePath());
            System.out.println("Writeable: " + myObj.canWrite());
            System.out.println("Readable " + myObj.canRead());
            System.out.println("File size in bytes " + myObj.length());
        } else {
            System.out.println("The file does not exist.");
        }
    }

}


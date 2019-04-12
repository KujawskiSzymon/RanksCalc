package com.company;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class SongDao {
    static BufferedReader reader;
    private String filename;



    public SongDao() {
        System.out.println("Podaj nazwe pliku jeszcze raz");
        boolean isCorrect=false;
        Scanner scanner = new Scanner(System.in);
        this.filename= scanner.next();
        while (!isCorrect)
        try{
            reader = new BufferedReader(new FileReader(filename));
            isCorrect=true;
        }
        catch (Exception e){
            System.out.println("Nazwa nieprawidłowa - podaj jeszcze raz");
            this.filename=scanner.next();


        }

    }

    public SongDao(String filename) {
        this.filename = filename;
       // boolean isCorrect=true;
        try {
            reader = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException e) {

            System.out.println("Oops! Wyglada na to ze taki plik nie istnieje!");

              new SongDao();
        } catch (NullPointerException e) {
            e.printStackTrace();
          //  isCorrect=false;
            System.out.println("Oops! Wyglada na to ze taki plik nie istnieje!");
         //   while(!isCorrect)


    }




        }
    }











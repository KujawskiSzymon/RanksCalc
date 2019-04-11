package com.company;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class SongDao {
    static BufferedReader reader;
    private String filename;



    public SongDao(String filename) {
        this.filename = filename;
        try {
            reader = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Oops! Wyglada na to ze taki plik nie istnieje!");
            //tworzenie wlasnego pliku
    }




        }
    }











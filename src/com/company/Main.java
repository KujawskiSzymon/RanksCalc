package com.company;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        //Testing
        System.out.println("***********************************");
        System.out.println();
        System.out.println("Program do wyliczania rankingow LOCAL Szymon Kujawski Hobby");
        System.out.println("Hollywood Undead !! - program do użytku prywatnego ");

        System.out.println();
        System.out.println("Program bedzie szukać pliku o nazwie 'plik.txt'");
        System.out.println("Czy chcesz podac wlasna nazwę pliku?(T/N)");
        Scanner scanner = new Scanner(System.in);
        boolean czyPlikNazwa = scanner.next().toUpperCase().equals("T");
        SongDao songDao;
        if (czyPlikNazwa) {
            System.out.print("Podaj nazwe pliku:");
            String name = scanner.next();
            songDao = new SongDao(name);
            System.out.println();

        } else {
            songDao = new SongDao("plik.txt");
        }






// rank manual
        /*
        System.out.println("Podaj ranking średni:");
        double srRank;
        try{
            srRank = scanner.nextDouble();
        }
        catch (InputMismatchException ex){
            System.out.println("Wczytales niepoprawną wartość - ranking zostanie ustawiony na 1600");
            srRank= 1600;
        }
        */
        List<Song> songs = new ArrayList<>();

         String name;
                String id;
                String score;
                Double rank;
                Double afterRank;
                String line = null;
                try {
                    line = songDao.reader.readLine();
                } catch (IOException e) {
                    e.getMessage();
                } catch (NullPointerException e) {
                    e.getMessage();
                }
                while (line != null) {
                    StringTokenizer tokenizer = new StringTokenizer(line, "|");
                    id = tokenizer.nextToken().trim();
                    name = tokenizer.nextToken().trim();
                    rank = Double.parseDouble(tokenizer.nextToken());
                    score = tokenizer.nextToken();

                    afterRank = Double.parseDouble(tokenizer.nextToken());

            Song song = new Song(id, name, score, rank, afterRank);
            songs.add(song);
            try {
                line = songDao.reader.readLine();
            } catch (IOException e) {
                e.getMessage();
            }

        }

        try {
            songDao.reader.close();
        } catch (IOException ex) {
            ex.getMessage();
        } catch (NullPointerException ex) {
            ex.getMessage();
        }
        //rank auto
        double sum=0;
                for(int i=0;i<songs.size();i++){
                   sum+=songs.get(i).getBeforeRank();
                }
               double srRank = sum/songs.size();
        System.out.println("Sredni ranking wynosi: "+srRank);
        Calc calc = new Calc(songs, srRank);
        List<SongAfter> songAfters = calc.LeagueCalc();


        PrintWriter writer=null;
        try {
            writer = new PrintWriter("wyniki.txt");
        } catch (FileNotFoundException ex) {
            ex.getMessage();
        }


            save(songAfters, writer);
        writer.close();



        System.out.println("Wyniki zostały zapisane w pliku wyniki.txt");

    }
        public static void save (List < SongAfter > songAfters, PrintWriter writer)  {
            for (int i = 0; i < songAfters.size(); i++) {
                writer.write(songAfters.get(i).getName() + " " + songAfters.get(i).getRank() + "\n");
                writer.println();
            }
        }

    }



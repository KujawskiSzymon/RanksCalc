package com.company;

import java.util.*;

 class Calc {

    private List<Song> songs;
    private double avgRank;


    public Calc(List<Song> songs, double avgRank) {

        this.songs = songs;
        this.avgRank = avgRank;

    }

    public List<SongAfter> LeagueCalc() {
        List<SongAfter> newsongs = new ArrayList<>();
        Integer afterRank;
        Double beforeRank;
        Double newRank;
        for (int i = 0; i < songs.size(); i++) {
            afterRank = songs.get(i).getAfterRank();
            beforeRank = songs.get(i).getBeforeRank();

            songs.get(i).setNewRank(calcRank(beforeRank, afterRank, avgRank, songs.get(i).getName()));
         /*   if ((afterRank > beforeRank) && (afterRank - beforeRank > 29)) {
                double modifier=1;
               // songs.get(i).setNewRank(beforeRank + ((afterRank - beforeRank) * 0.40));
                double addRank = ((afterRank - beforeRank) * 0.40);

                if(songs.get(i).getBeforeRank()>avgRank) {
                    double tmp = songs.get(i).getBeforeRank();

                    while (tmp>avgRank){
                        if(modifier<0.30) {
                            break;
                        }
                        modifier -= 0.015;
                        tmp-=10;

                    }

                    songs.get(i).setNewRank(songs.get(i).getBeforeRank()+(addRank*modifier));


                }
                else {
                    double tmp = songs.get(i).getBeforeRank();
                    while (tmp<=avgRank){
                        modifier+=0.01;
                        tmp+=10;
                    }
                    System.out.println(modifier);
                    songs.get(i).setNewRank(songs.get(i).getBeforeRank()+(addRank*modifier));
                }
                */
            newRank = songs.get(i).getNewRank();


            //  System.out.println(songs.get(i).getName() + " zdobywa wyzszy ranking: " + newRank + " ( wczesniej " + beforeRank + " )");

            SongAfter songAfter = new SongAfter(songs.get(i).getName(), songs.get(i).getNewRank());
            newsongs.add(songAfter);
        }


        return newsongs;
    }

    public static double calcRank(double beforeRank,  double afterRank, double avgRank, String songName) {
        double modifier = 1;
            if ((afterRank > beforeRank) && (afterRank - beforeRank > 29)) {
             //   double modifier = 1;
                // songs.get(i).setNewRank(beforeRank + ((afterRank - beforeRank) * 0.40));
                double addRank = ((afterRank - beforeRank) * 0.40);

                if (beforeRank > avgRank) {
                    double tmp = beforeRank;

                    while (tmp > avgRank) {
                        if (modifier < 0.30) {
                            break;
                        }
                        modifier -= 0.015;
                        tmp -= 10;

                    }

                    return beforeRank + (addRank * modifier);


                } else {
                    double tmp = beforeRank;
                    while (tmp <= avgRank) {
                        modifier += 0.01;
                        tmp += 10;
                    }
                    System.out.println(songName + "zyskał ranking " + beforeRank + " nowy: " +( beforeRank + (addRank * modifier)));
                    return beforeRank + (addRank * modifier);
                }
//TODO - ustawic exception, zrobic porzadek w Mainie
            } else if ((beforeRank > afterRank) && (beforeRank - afterRank > 29)) {
            /*    System.out.println(songName + " stracił ranking  " + beforeRank + " nowy: " + (beforeRank -(beforeRank - afterRank) * 0.30));
                return (beforeRank - ((beforeRank - afterRank) * 0.30));
*/
                double subRank = ((beforeRank - afterRank) * 0.40);

                if (beforeRank > avgRank) {
                    double tmp = beforeRank;

                    while (tmp > avgRank) {
                        if (modifier < 0.30) {
                            break;
                        }
                        modifier += 0.015;
                        tmp -= 10;

                    }

                    return beforeRank - (subRank * modifier);


                } else {
                    double tmp = beforeRank;
                    while (tmp <= avgRank) {
                        modifier -= 0.01;
                        tmp += 10;
                    }
                    System.out.println(songName + "stracił ranking " + beforeRank + " nowy: " +( beforeRank - (subRank * modifier)));
                    return beforeRank + (subRank * modifier);


            }} else {
                 System.out.println(songName + " nie zmienił rankingu ( " + beforeRank + " )");
                return beforeRank;
            }
    }}


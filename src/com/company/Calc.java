package com.company;

import java.util.ArrayList;
import java.util.List;

public class Calc {

    private  List<Song> songs;

    public Calc(List<Song> songs) {

        this.songs = songs;

    }

    public List<SongAfter> LeagueCalc(List<Song> songs, int system) {
        List<SongAfter> newsongs = new ArrayList<>();
        Integer afterRank;
        Double beforeRank;
        Double newRank;
        for (int i = 0; i < songs.size(); i++) {
            afterRank = songs.get(i).getAfterRank();
            beforeRank = songs.get(i).getBeforeRank();
            if (afterRank > beforeRank && afterRank - beforeRank > 29) {
                songs.get(i).setNewRank(beforeRank + ((afterRank - beforeRank) * 0.40));
                newRank = songs.get(i).getNewRank();
                switch(system) {
                    case 1:
                        if (newRank > 2200) {
                            songs.get(i).setNewRank((double) 2200);
                            newRank = (double) 2200;
                        }
                        break;
                    case 2:
                        if (newRank > 2000)
                            songs.get(i).setNewRank((double)2000);
                        break;
                    case 3:
                        if (newRank > 1800)
                            songs.get(i).setNewRank((double)1800);
                        break;
                    default:
                        break;
                }

                    System.out.println(songs.get(i).getName() + " zdobywa wyzszy ranking: " + newRank + " ( wczesniej " + beforeRank + " )");


            } else if (beforeRank > afterRank && beforeRank - afterRank > 29) {
                songs.get(i).setNewRank(beforeRank + ((beforeRank - afterRank) * 0.30));
                newRank = songs.get(i).getNewRank();
                System.out.println(songs.get(i).getName() + " traci ranking: " + newRank + " ( wczesniej " + beforeRank + " )");
            } else {
                System.out.println(songs.get(i).getName() + " nie zmienił rankingu ( " + beforeRank + " )");
                songs.get(i).setNewRank(beforeRank);
            }
            SongAfter songAfter = new SongAfter(songs.get(i).getName(),songs.get(i).getNewRank());
            newsongs.add(songAfter);
        }
        return newsongs;
    }

}

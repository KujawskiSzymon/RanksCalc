package com.company;

public class Song {
    private String id;
    private String name;
    private String score;

    private Double beforeRank;
    private Double afterRank;
    private Double newRank;


    public Song(String id, String name, String score, Double beforeRank, Double afterRank) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.beforeRank = beforeRank;
        this.afterRank = afterRank;
        this.newRank = null;
    }

    public String getId() {
        return id;
    }

    public String getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public Double getBeforeRank() {
        return beforeRank;
    }

    public Double getAfterRank() {
        return afterRank;
    }

    public Double getNewRank() {
        return newRank;
    }

    public void setNewRank(Double newRank) {
        this.newRank = newRank;
    }
}

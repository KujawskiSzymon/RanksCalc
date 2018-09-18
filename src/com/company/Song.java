package com.company;

public class Song {
    private String name;
    private Double beforeRank;
    private Integer afterRank;
    private Double newRank;

    public Song(String name, Double beforeRank, Integer afterRank) {
        this.name = name;
        this.beforeRank = beforeRank;
        this.afterRank = afterRank;
        this.newRank = null;
    }

    public String getName() {
        return name;
    }

    public Double getBeforeRank() {
        return beforeRank;
    }

    public Integer getAfterRank() {
        return afterRank;
    }

    public Double getNewRank() {
        return newRank;
    }

    public void setNewRank(Double newRank) {
        this.newRank = newRank;
    }
}

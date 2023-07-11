package com.offcn.imovie.pojo;

public class Movie {
    Integer id;
    String moviename;
    String time;
    String saveimagepath;
    double score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSaveimagepath() {
        return saveimagepath;
    }

    public void setSaveimagepath(String saveimagepath) {
        this.saveimagepath = saveimagepath;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}

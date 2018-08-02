package com.exampleandroiddemottest.petagramrecyclerview.pojo;

import android.support.annotation.NonNull;

public class Mascota implements Comparable<Mascota> {

    public Mascota() {

    }

    public int getImageMain() {
        return imageMain;
    }

    public void setImageMain(int imageMain) {
        this.imageMain = imageMain;
    }

    private  int id;
    private int imageMain;
    private String namePets;
    private int likes;



    public Mascota(int imageMain, String namePets, int likes) {
        this.imageMain = imageMain;
        this.namePets = namePets;
        this.likes = likes;
    }

    public String getNamePets() {
        return namePets;
    }

    public void setNamePets(String namePets) {
        this.namePets = namePets;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(@NonNull Mascota mascota) {

        int compareage= mascota.getLikes();
        /* For Ascending order*/
        //return this.likes-compareage;
        return compareage-this.likes;

        //return String.valueOf(mascota.getLikes()).compareTo(String.valueOf(mascota.getLikes()));
     //   return String.valueOf(mascota.getLikes()).compareTo(String.valueOf(mascota.getLikes()));
    }
}

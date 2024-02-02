package com.mikaela.novelcore.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity(tableName = "SCENE")
public class Scene {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private String id;
    private String episodeName;
    private int number;
    private String background;
    private ArrayList<java.lang.Character> characters;
    private String mcSay;

    public Scene(String id, String episodeName, int number, String background, ArrayList<java.lang.Character> characters, String mcSay) {
        this.id = id;
        this.episodeName = episodeName;
        this.number = number;
        this.background = background;
        this.characters = characters;
        this.mcSay = mcSay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEpisodeName() {
        return episodeName;
    }

    public void setEpisodeName(String episodeName) {
        this.episodeName = episodeName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public ArrayList<java.lang.Character> getCharacters() {
        return characters;
    }

    public void setCharacters(ArrayList<java.lang.Character> characters) {
        this.characters = characters;
    }

    public String getMcSay() {
        return mcSay;
    }

    public void setMcSay(String mcSay) {
        this.mcSay = mcSay;
    }
}
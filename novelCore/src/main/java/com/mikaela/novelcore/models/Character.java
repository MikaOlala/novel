package com.mikaela.novelcore.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "CHARACTER")
public class Character {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    private String sceneId;
    private String sprite;
    private String characterSays;

    public Character(String sceneId, String sprite, String characterSays) {
        this.sceneId = sceneId;
        this.sprite = sprite;
        this.characterSays = characterSays;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSceneId() {
        return sceneId;
    }

    public void setSceneId(String sceneId) {
        this.sceneId = sceneId;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    public String getCharacterSays() {
        return characterSays;
    }

    public void setCharacterSays(String characterSays) {
        this.characterSays = characterSays;
    }
}

package com.mikaela.novelcore.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.mikaela.novelcore.models.Character;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface CharacterDao {
    @Insert
    void insert(List<Character> list);

    @Query("select * from CHARACTER where sceneId = :sceneId")
    LiveData<List<Character>> getCharacters(String sceneId);

    @Query("delete from CHARACTER")
    void deleteAll();
}

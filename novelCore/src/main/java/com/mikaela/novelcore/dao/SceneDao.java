package com.mikaela.novelcore.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.mikaela.novelcore.models.Scene;

import java.util.List;

@Dao
public interface SceneDao {
    @Insert
    void insert(List<Scene> list);

    @Query("select * from SCENE where episodeName = :episodeName")
    LiveData<List<Scene>> getScenes(String episodeName);

    @Query("delete from SCENE")
    void deleteAll();
}

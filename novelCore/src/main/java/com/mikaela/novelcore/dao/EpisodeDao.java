package com.mikaela.novelcore.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.mikaela.novelcore.models.Episode;

import java.util.List;

@Dao
public interface EpisodeDao {
    @Insert
    void insert(List<Episode> list);

    @Query("select * from EPISODE")
    LiveData<List<Episode>> getEpisodes();

    @Query("delete from EPISODE")
    void deleteAll();
}

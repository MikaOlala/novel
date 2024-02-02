package com.mikaela.novelcore.models;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.mikaela.novelcore.dao.CharacterDao;
import com.mikaela.novelcore.dao.EpisodeDao;
import com.mikaela.novelcore.dao.SceneDao;

@androidx.room.Database(entities = {
        Episode.class,
        Character.class,
        Scene.class
}, version = 1)
public abstract class Database extends RoomDatabase {
    private static Database instance;
    public abstract EpisodeDao episodeDao();
    public abstract CharacterDao characterDao();
    public abstract SceneDao sceneDao();

    public static synchronized Database getInstance(Context context) {
        if (instance==null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), Database.class, "novel_database")
                    .fallbackToDestructiveMigration() // при ошибке в миграции удаляет данные
                    .build();
        }
        return instance;
    }
}

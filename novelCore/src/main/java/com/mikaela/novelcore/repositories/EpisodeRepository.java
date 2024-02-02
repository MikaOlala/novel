package com.mikaela.novelcore.repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.mikaela.novelcore.dao.EpisodeDao;
import com.mikaela.novelcore.models.Database;
import com.mikaela.novelcore.models.Episode;


import java.util.List;

public class EpisodeRepository {
    private EpisodeDao dao;

    public EpisodeRepository(Application application) {
        Database database = Database.getInstance(application);
        this.dao = database.episodeDao();
    }

    public void insert(List<Episode> list) {
        new InsertAsync(dao).execute(list);
    }

    public LiveData<List<Episode>> getEpisodes() {
        return dao.getEpisodes();
    }

    public void deleteAll() {
        new DeleteAllAsync(dao).execute();
    }

    public static class InsertAsync extends AsyncTask<List<Episode>, Void, Void> {
        private EpisodeDao dao;

        public InsertAsync(EpisodeDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(List<Episode>... lists) {
            dao.insert(lists[0]);
            return null;
        }
    }

    public static class DeleteAllAsync extends AsyncTask<Void, Void, Void> {
        private EpisodeDao dao;

        public DeleteAllAsync(EpisodeDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            dao.deleteAll();
            return null;
        }
    }
}

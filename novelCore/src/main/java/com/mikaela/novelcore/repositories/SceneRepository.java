package com.mikaela.novelcore.repositories;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.mikaela.novelcore.dao.SceneDao;
import com.mikaela.novelcore.models.Database;
import com.mikaela.novelcore.models.Scene;

import java.util.List;

public class SceneRepository {
    private SceneDao dao;

    public SceneRepository(Application application) {
        Database database = Database.getInstance(application);
        this.dao = database.sceneDao();
    }

    public void insert(List<Scene> list) {
        new InsertAsync(dao).execute(list);
    }

    public LiveData<List<Scene>> getScenes(String episodeName) {
        return dao.getScenes(episodeName);
    }

    public void deleteAll() {
        new DeleteAllAsync(dao).execute();
    }

    public static class InsertAsync extends AsyncTask<List<Scene>, Void, Void> {
        private SceneDao dao;

        public InsertAsync(SceneDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(List<Scene>... lists) {
            dao.insert(lists[0]);
            return null;
        }
    }

    public static class DeleteAllAsync extends AsyncTask<Void, Void, Void> {
        private SceneDao dao;

        public DeleteAllAsync(SceneDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            dao.deleteAll();
            return null;
        }
    }
}

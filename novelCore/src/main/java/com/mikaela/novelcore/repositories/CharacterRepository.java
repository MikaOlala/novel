package com.mikaela.novelcore.repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.mikaela.novelcore.dao.CharacterDao;
import com.mikaela.novelcore.models.Character;
import com.mikaela.novelcore.models.Database;

import java.util.ArrayList;
import java.util.List;

public class CharacterRepository {
    private CharacterDao dao;

    public CharacterRepository(Application application) {
        Database database = Database.getInstance(application);
        this.dao = database.characterDao();
    }

    public void insert(List<Character> list) {
        new InsertAsync(dao).execute(list);
    }

    public LiveData<List<Character>> getCharacters(String sceneId) {
        return dao.getCharacters(sceneId);
    }

    public void deleteAll() {
        new DeleteAllAsync(dao).execute();
    }


    private static class InsertAsync extends AsyncTask<List<Character>, Void, Void> {
        private final CharacterDao dao;

        public InsertAsync(CharacterDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(List<Character>[] lists) {
            dao.insert(lists[0]);
            return null;
        }
    }

    private static class DeleteAllAsync extends AsyncTask<Void, Void, Void> {
        private final CharacterDao dao;

        public DeleteAllAsync(CharacterDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            dao.deleteAll();
            return null;
        }
    }
}

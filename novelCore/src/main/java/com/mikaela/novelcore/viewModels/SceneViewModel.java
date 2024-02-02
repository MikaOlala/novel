package com.mikaela.novelcore.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.mikaela.novelcore.models.Scene;
import com.mikaela.novelcore.repositories.SceneRepository;

import java.util.List;

public class SceneViewModel extends AndroidViewModel {
    private SceneRepository repository;

    public SceneViewModel(@NonNull Application application) {
        super(application);
        repository = new SceneRepository(application);
    }

    public void insert(List<Scene> list) {
        repository.insert(list);
    }

    public LiveData<List<Scene>> getScenes(String episodeName) {
        return repository.getScenes(episodeName);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}

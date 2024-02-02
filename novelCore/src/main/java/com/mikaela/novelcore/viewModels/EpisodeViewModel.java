package com.mikaela.novelcore.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.mikaela.novelcore.dao.EpisodeDao;
import com.mikaela.novelcore.models.Episode;
import com.mikaela.novelcore.repositories.EpisodeRepository;
import com.mikaela.novelcore.repositories.EpisodeRepository;

import java.util.List;

public class EpisodeViewModel extends AndroidViewModel {
    private EpisodeRepository repository;

    public EpisodeViewModel(@NonNull Application application) {
        super(application);
        repository = new EpisodeRepository(application);
    }

    public void insert(List<Episode> list) {
        repository.insert(list);
    }

    public LiveData<List<Episode>> getEpisodes() {
        return repository.getEpisodes();
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}

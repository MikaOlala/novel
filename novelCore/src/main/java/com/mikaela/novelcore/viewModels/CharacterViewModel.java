package com.mikaela.novelcore.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.mikaela.novelcore.models.Character;
import com.mikaela.novelcore.repositories.CharacterRepository;

import java.util.List;

public class CharacterViewModel extends AndroidViewModel {
    private CharacterRepository repository;

    public CharacterViewModel(@NonNull Application application) {
        super(application);
        repository = new CharacterRepository(application);
    }

    public void insert(List<Character> list) {
        repository.insert(list);
    }

    public LiveData<List<Character>> getCharacters(String sceneId) {
        return repository.getCharacters(sceneId);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}

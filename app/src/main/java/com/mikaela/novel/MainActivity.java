package com.mikaela.novel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.mikaela.novel.adapters.EpisodeAdapter;
import com.mikaela.novel.adapters.Utils;
import com.mikaela.novelcore.models.Episode;
import com.mikaela.novelcore.viewModels.EpisodeViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private List<Episode> episodes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler = findViewById(R.id.recycler);

        getEpisodeList();
    }

    private void getEpisodeList() {
        EpisodeViewModel episodeVM = new ViewModelProvider(this).get(EpisodeViewModel.class);
        episodeVM.getEpisodes().observe(this, episodes -> {
            this.episodes = episodes;
            setAdapter();
        });
    }

    private void setAdapter() {
        EpisodeAdapter adapter = new EpisodeAdapter(episodes, this);
        Utils.getRecycler(this, recycler).setAdapter(adapter);

    }
}
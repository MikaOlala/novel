package com.mikaela.novel.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mikaela.novel.R;
import com.mikaela.novelcore.models.Episode;

import java.util.List;

public class EpisodeAdapter extends RecyclerView.Adapter<EpisodeAdapter.CardViewHolder> {

    public List<Episode> list;
    public Context context;

    public static class CardViewHolder extends RecyclerView.ViewHolder {

        public TextView text;
        public ImageView image;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
            image = itemView.findViewById(R.id.image);
        }
    }

    public EpisodeAdapter(List<Episode> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.block_menu, parent, false);
        return new CardViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Episode episode = list.get(position);
        holder.text.setText(R.string.episode + episode.getId());

        int id = context.getResources().getIdentifier(episode.getImage(), "drawable", context.getPackageName());
        if (id!=0) {
            holder.image.setImageResource(id);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

package com.example.itube;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.ViewHolder> {

    private Context ctx_for;
    private List<String> list_for;
    private OnVideoClickListener click_for;

    public PlaylistAdapter(Context ctx_for, List<String> list_for, OnVideoClickListener click_for) {
        this.ctx_for = ctx_for;
        this.list_for = list_for;
        this.click_for = click_for;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent_for, int viewType_for) {
        View view_for = LayoutInflater.from(ctx_for).inflate(R.layout.item_playlist, parent_for, false);
        return new ViewHolder(view_for);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder_for, int pos_for) {
        String url_for = list_for.get(pos_for);
        holder_for.textView_for.setText(url_for);
        holder_for.itemView.setOnClickListener(v -> click_for.onVideoClick(url_for));
    }

    @Override
    public int getItemCount() {
        return list_for.size();
    }

    public interface OnVideoClickListener {
        void onVideoClick(String url_for);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView_for;

        public ViewHolder(View itemView) {
            super(itemView);
            textView_for = itemView.findViewById(R.id.textUrl);
        }
    }
}

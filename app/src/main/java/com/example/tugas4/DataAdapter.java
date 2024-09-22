package com.example.tugas4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private List<Data> dataList;

    public DataAdapter(List<Data> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Data item = dataList.get(position);
        holder.textViewNama.setText(item.getNama());
        holder.textViewNim.setText(item.getNim());
        holder.imageViewFoto.setImageResource(R.mipmap.ic_launcher);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNama;
        TextView textViewNim;
        ImageView imageViewFoto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNama = itemView.findViewById(R.id.textViewNama);
            textViewNim = itemView.findViewById(R.id.textViewNim);
            imageViewFoto = itemView.findViewById(R.id.imageViewFoto);
        }
    }
}
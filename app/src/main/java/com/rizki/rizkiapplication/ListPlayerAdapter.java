package com.rizki.rizkiapplication;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import static com.rizki.rizkiapplication.R.*;

public class ListPlayerAdapter extends RecyclerView.Adapter<ListPlayerAdapter.ListViewHolder> {

    private LinearLayout linearLayout;

    private ArrayList<String> fotoPemain = new ArrayList<>();
    private ArrayList<String> namaPemain = new ArrayList<>();
    private ArrayList<String> posisiPemain = new ArrayList<>();
    private ArrayList<String> negaraPemain = new ArrayList<>();
    //private ArrayList<String> infoPemain = new ArrayList<>();
    private Context context;

    public ListPlayerAdapter(ArrayList<String> fotoPemain, ArrayList<String> namaPemain, ArrayList<String> negaraPemain,
                             ArrayList<String> posisiPemain, Context context) {
        this.fotoPemain = fotoPemain;
        this.namaPemain = namaPemain;
        this.posisiPemain = posisiPemain;
        this.negaraPemain = negaraPemain;
        //this.infoPemain = infoPemain;
        this.context = context;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_player, parent, false);
        ListViewHolder holder = new ListViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, final int position) {

        Glide.with(context)
                .load(fotoPemain.get(position))
                .apply(new RequestOptions().override(65, 65))
                .into(holder.imgPhoto);
        holder.tvName.setText(namaPemain.get(position));
        holder.tvPosition.setText(posisiPemain.get(position));
        holder.tvNation.setText(negaraPemain.get(position));

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, namaPemain.get(position), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, Detail.class);
                intent.putExtra("image_url", fotoPemain.get(position));
                intent.putExtra("nama_pemain", namaPemain.get(position));
                intent.putExtra("posisi_pemain", posisiPemain.get(position));
                intent.putExtra("negara", negaraPemain.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return namaPemain.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        ImageView imgPhoto;
        TextView tvName, tvPosition, tvNation;
        LinearLayout linearLayout;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(id.imgPlayer);
            tvName = itemView.findViewById(id.tv_pemain);
            tvPosition = itemView.findViewById(id.tv_posisi);
            tvNation = itemView.findViewById(id.tv_negara);
            linearLayout = itemView.findViewById(id.linear);
        }
    }
}

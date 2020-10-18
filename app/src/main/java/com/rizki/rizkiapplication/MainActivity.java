package com.rizki.rizkiapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    private RecyclerView rvLiverpool;
    private ArrayList<String> fotoPemain = new ArrayList<>();
    private ArrayList<String> namaPemain = new ArrayList<>();
    private ArrayList<String> posisiPemain = new ArrayList<>();
    private ArrayList<String> negaraPemain = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView imageView = findViewById(R.id.imgabout);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, About.class);
                startActivity(intent);
            }
        });

        getData();
    }

    private void prosesRecyclerViewAdapter(){
        RecyclerView recyclerView = findViewById(R.id.rv_liverpool);
        ListPlayerAdapter adapter = new ListPlayerAdapter(fotoPemain, namaPemain, posisiPemain, negaraPemain, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getData(){
        fotoPemain.add("https://resources.premierleague.com/premierleague/photos/players/250x250/p116535.png");
        namaPemain.add("Allison Becker");
        posisiPemain.add("Goalkeeper");
        negaraPemain.add("Brazil");

        fotoPemain.add("https://resources.premierleague.com/premierleague/photos/players/250x250/p122798.png");
        namaPemain.add("Andrew Roberson");
        posisiPemain.add("Defender");
        negaraPemain.add("Scotland");

        fotoPemain.add("https://resources.premierleague.com/premierleague/photos/players/110x140/p97032.png");
        namaPemain.add("Virgil van Dijk");
        posisiPemain.add("Defender");
        negaraPemain.add("Netherland");

        fotoPemain.add("https://resources.premierleague.com/premierleague/photos/players/110x140/p60914.png");
        namaPemain.add("Joel Matip");
        posisiPemain.add("Defender");
        negaraPemain.add("Cameroon");

        fotoPemain.add("https://resources.premierleague.com/premierleague/photos/players/250x250/p169187.png");
        namaPemain.add("Trent Alexander-Arnold");
        posisiPemain.add("Defender");
        negaraPemain.add("England");

        fotoPemain.add("https://resources.premierleague.com/premierleague/photos/players/110x140/p56979.png");
        namaPemain.add("Jordan Henderson");
        posisiPemain.add("Midfielder");
        negaraPemain.add("England");

        fotoPemain.add("https://resources.premierleague.com/premierleague/photos/players/110x140/p116643.png");
        namaPemain.add("Fabinho");
        posisiPemain.add("Midfielder");
        negaraPemain.add("Brazil");

        fotoPemain.add("https://resources.premierleague.com/premierleague/photos/players/250x250/p41733.png");
        namaPemain.add("Georginio Wijnaldum");
        posisiPemain.add("Midfielder");
        negaraPemain.add("Netherland");

        fotoPemain.add("https://resources.premierleague.com/premierleague/photos/players/110x140/p110979.png");
        namaPemain.add("Sadio Mane");
        posisiPemain.add("Forward");
        negaraPemain.add("Senegal");

        fotoPemain.add("https://resources.premierleague.com/premierleague/photos/players/110x140/p92217.png");
        namaPemain.add("Roberto Firmino");
        posisiPemain.add("Forward");
        negaraPemain.add("Brazil");

        fotoPemain.add("https://resources.premierleague.com/premierleague/photos/players/110x140/p118748.png");
        namaPemain.add("Mohamed Salah");
        posisiPemain.add("Forward");
        negaraPemain.add("Egypt");

        prosesRecyclerViewAdapter();
    }

}

package com.rizki.rizkiapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class Detail extends AppCompatActivity {

    ImageView imgdetail;
    TextView namadetail, posisidetail, nationdetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imgdetail = findViewById(R.id.imgdetail);
        namadetail = findViewById(R.id.namadetail);
        posisidetail = findViewById(R.id.posisidetail);
        nationdetail = findViewById(R.id.nationdetail);

        getIncomingExtra();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ImageView imgback = toolbar.findViewById(R.id.imgback);
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Detail.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }

    private void getIncomingExtra() {
            String pemainFoto = getIntent().getStringExtra("image_url");
            String pemainNama = getIntent().getStringExtra("nama_pemain");
            String pemainPosisi = getIntent().getStringExtra("posisi_pemain");
            String pemainNegara = getIntent().getStringExtra("negara");

            setDataActivity(pemainFoto, pemainNama, pemainPosisi, pemainNegara);
    }

    private void setDataActivity(String pemainFoto, String pemainNama,
                                 String pemainPosisi, String pemainNegara) {

        Glide.with(this)
                .asBitmap()
                .load(pemainFoto)
                .apply(new RequestOptions().override(150, 150))
                .into(imgdetail);
        namadetail.setText(pemainNama);
        posisidetail.setText(pemainPosisi);
        nationdetail.setText(pemainNegara);
    }
}

package com.Indriyanto.dicoding_submission;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.Indriyanto.dicoding_submission.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.Calendar;
import java.util.TimeZone;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class DetailWisata extends AppCompatActivity {
    TextView txttarifmasuk, txtnamawisata,txtlokasi, txtdeskripsi,txtkategori;
    String namaWisata, tiketmasuk, deskripsi, alamat, kategori;
    Button btnreservasi;

    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wisata_jogja);

        setActionBarTitle("Detail Wisata");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);// set drawable icon
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtnamawisata = findViewById(R.id.txtnamawisata);
        txttarifmasuk = findViewById(R.id.txttarifmasuk);
        txtlokasi = findViewById(R.id.txtlokasi);
        txtdeskripsi = findViewById(R.id.txtdeskripsi);
        txtkategori = findViewById(R.id.txtkategori);
        image = findViewById(R.id.image);
        btnreservasi = findViewById(R.id.btnreservasi);

        kategori = getIntent().getStringExtra("kategori");
        namaWisata = getIntent().getStringExtra("namaWisata");
        tiketmasuk = getIntent().getStringExtra("tiketmasuk");
        alamat = getIntent().getStringExtra("alamat");
        deskripsi = getIntent().getStringExtra("deskripsi");
        int gambar = getIntent().getIntExtra("gambar", 0);

        txtkategori.setText(kategori);
        txtnamawisata.setText(namaWisata);
        txttarifmasuk.setText(tiketmasuk);
        txtlokasi.setText(alamat);
        txtdeskripsi.setText(deskripsi);
        image.setImageResource(gambar);


        btnreservasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext() ,"Berhasil Reservasi di " +namaWisata + "\n dengan harga :" +tiketmasuk ,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}

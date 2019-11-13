package com.Indriyanto.dicoding_submission.Jogjakarta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.Indriyanto.dicoding_submission.JawaTengah.AdapterJawaTengah;
import com.Indriyanto.dicoding_submission.R;

import java.util.ArrayList;

public class ListYogyakarta extends AppCompatActivity {
    private RecyclerView listwisatajogja;

    private ArrayList<Yokyakarta> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_yogyakarta);

        setActionBarTitle("List Wisata Yogyakarta");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);// set drawable icon
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listwisatajogja = findViewById(R.id.listwisatajogja);
        listwisatajogja.setHasFixedSize(true);

        list.addAll(DataWisataJogja.getListData());
        showRecyclerList();

    }

    private void showRecyclerList(){
        listwisatajogja.setLayoutManager(new LinearLayoutManager(this));
        AdapterYogyakarta adapterYogyakarta = new AdapterYogyakarta(list);
        listwisatajogja.setAdapter(adapterYogyakarta);
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

}

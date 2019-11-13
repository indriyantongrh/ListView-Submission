package com.Indriyanto.dicoding_submission.JawaTengah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.Indriyanto.dicoding_submission.R;

import java.util.ArrayList;

public class ListJawaTengah extends AppCompatActivity {

    RecyclerView listwisatajateng;
    private ArrayList<JawaTengah> list = new ArrayList<>();
    AdapterJawaTengah adapterJawaTengah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_jawa_tengah);

        setActionBarTitle("List Wisata Jawa Tengah");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);// set drawable icon
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listwisatajateng = findViewById(R.id.listwisatajateng);
        listwisatajateng.setHasFixedSize(true);

        list.addAll(DataWisataJawaTengah.getListData());

        showRecyclerCardView();
    }

    private void showRecyclerCardView(){
        listwisatajateng.setLayoutManager(new LinearLayoutManager(this));
        AdapterJawaTengah adapterJawaTengah = new AdapterJawaTengah(list);
        listwisatajateng.setAdapter(adapterJawaTengah);
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

}

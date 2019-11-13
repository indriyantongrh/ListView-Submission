package com.Indriyanto.dicoding_submission.JawaTimur;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.Indriyanto.dicoding_submission.Jogjakarta.AdapterYogyakarta;
import com.Indriyanto.dicoding_submission.Jogjakarta.DataWisataJogja;
import com.Indriyanto.dicoding_submission.Jogjakarta.Yokyakarta;
import com.Indriyanto.dicoding_submission.R;

import java.util.ArrayList;

public class ListJawaTimur extends AppCompatActivity {
    private RecyclerView listwisatajatim;

    private ArrayList<JawaTimur> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_jawa_timur);

        setActionBarTitle("List Wisata Jawa Timur");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);// set drawable icon
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listwisatajatim = findViewById(R.id.listwisatajatim);
        listwisatajatim.setHasFixedSize(true);

        list.addAll(DataWisataJawaTimur.getListData());
        showRecyclerList();

    }

    private void showRecyclerList(){
        listwisatajatim.setLayoutManager(new LinearLayoutManager(this));
        AdapterJawaTimur adapterJawaTimur = new AdapterJawaTimur(list);
        listwisatajatim.setAdapter(adapterJawaTimur);
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

}

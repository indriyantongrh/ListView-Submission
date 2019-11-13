package com.Indriyanto.dicoding_submission.JawaBarat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.Indriyanto.dicoding_submission.JawaTengah.AdapterJawaTengah;
import com.Indriyanto.dicoding_submission.JawaTengah.DataWisataJawaTengah;
import com.Indriyanto.dicoding_submission.JawaTengah.JawaTengah;
import com.Indriyanto.dicoding_submission.R;

import java.util.ArrayList;

public class ListJawaBarat extends AppCompatActivity {

    RecyclerView listwisatajabar;
    private ArrayList<JawaBarat> list = new ArrayList<>();
    AdapterJawaBarat adapterJawaBarat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_jawa_barat);

        setActionBarTitle("List Wisata Jawa Barat");

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);// set drawable icon
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listwisatajabar = findViewById(R.id.listwisatajabar);
        listwisatajabar.setHasFixedSize(true);

        list.addAll(DataWisataJawaBarat.getListData());

        showRecyclerCardView();

    }

    private void showRecyclerCardView(){
        listwisatajabar.setLayoutManager(new LinearLayoutManager(this));
        AdapterJawaBarat adapterJawaBarat = new AdapterJawaBarat(list);
        listwisatajabar.setAdapter(adapterJawaBarat);
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }


}

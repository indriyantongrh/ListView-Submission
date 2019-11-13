package com.Indriyanto.dicoding_submission;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.Indriyanto.dicoding_submission.JawaBarat.ListJawaBarat;
import com.Indriyanto.dicoding_submission.JawaTengah.ListJawaTengah;
import com.Indriyanto.dicoding_submission.JawaTimur.ListJawaTimur;
import com.Indriyanto.dicoding_submission.Jogjakarta.ListYogyakarta;

public class MainActivity extends AppCompatActivity {

    private String title = "Halaman Utama";

    CardView btnjateng, btnjabar, btnjatim,btnjogja;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setActionBarTitle(title);


        btnjateng = findViewById(R.id.btnjateng);
        btnjateng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListJawaTengah.class);
                startActivity(intent);
            }
        });

        btnjabar = findViewById(R.id.btnjabar);
        btnjabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListJawaBarat.class);
                startActivity(intent);
            }
        });
        btnjatim = findViewById(R.id.btnjatim);
        btnjatim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListJawaTimur.class);
                startActivity(intent);
            }
        });
        btnjogja = findViewById(R.id.btnjogja);
        btnjogja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListYogyakarta.class);
                startActivity(intent);
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profile,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_profile:gotoprofile();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void gotoprofile() {
        Intent intent_profile = new Intent(this, About.class);
        intent_profile.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent_profile);
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

}

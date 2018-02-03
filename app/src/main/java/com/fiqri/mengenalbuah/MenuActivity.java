package com.fiqri.mengenalbuah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //TODO kenalin dan hubungin
        Button mListView = findViewById(R.id.btnListView);
        Button mRecyclerVIew = findViewById(R.id.btnRecyclerView);

        mListView.setOnClickListener(this);
        mRecyclerVIew.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //TODO cek id yang diklik
        if (view.getId() == R.id.btnListView) {
            //TODO menggunakan intent untuk berpindah dari aktivity 1 ke yang lainnya
            startActivity(new Intent(MenuActivity.this, MainActivity.class));
        }else if (view.getId() == R.id.btnRecyclerView) {
            startActivity(new Intent(MenuActivity.this, RecyclerActivity.class));
        }
    }
}

package com.fiqri.mengenalbuah;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class RecyclerActivity extends AppCompatActivity {
    //TODO bit.ly/MengenalBuah1 / bit.ly/MengenalBuah
    //TODO create Array dan kenalin
    String nama_buah[] = {"Alpukat", "Apel", "Ceri", "Durian", "Jambu Air", "Manggis", "Straberry"};

    int gambar_buah[] = {R.drawable.alpukat, R.drawable.apel, R.drawable.ceri, R.drawable.durian, R.drawable.jambuair, R.drawable.manggis, R.drawable.strawberry};

    int suara_buah[]= {R.raw.alpukat, R.raw.apel, R.raw.ceri, R.raw.durian, R.raw.jambuair, R.raw.manggis, R.raw.strawberry};

    RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        //TODO hubungin
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        //TODO setLayout
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //TODO call custom Adapter
        CustomAdapter mAdapter = new CustomAdapter();
        //TODO setAdapter
        mRecyclerView.setAdapter(mAdapter);
    }

    //TODO create adapter dari Recycler
    private class CustomAdapter extends RecyclerView.Adapter<CustomHolder>{

        @Override
        public CustomHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //TODO menghubungkan dengan item_list
            View mView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list, parent, false);
            return new CustomHolder(mView);
        }

        @Override
        public void onBindViewHolder(CustomHolder holder, final int position) {
            //TODO ngapain dari holder
            holder.mNamaBuah.setText(nama_buah[position]);
            holder.mImageView.setImageResource(gambar_buah[position]);
            //TODO aksi ketika diklik itemnya
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //TODO menjalankan Musik
                    Uri uri = Uri.parse("android.resource://"+getPackageName()+ "/"+ suara_buah[position]);
                    MediaPlayer mPlayer = new MediaPlayer();
                    mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    try {
                        mPlayer.setDataSource(RecyclerActivity.this, uri);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        mPlayer.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    mPlayer.start();
                    //TODO mengubah posisi
//                    if (position == 0){
//                        //TODO set grid
//                        mRecyclerView.setLayoutManager(new GridLayoutManager(RecyclerActivity.this, 2));
//                        CustomAdapter mAdapter =new CustomAdapter();
//                        mRecyclerView.setAdapter(mAdapter);
//                    }else if (position==1){
//                        //TODO set Linear
//                        mRecyclerView.setLayoutManager(new LinearLayoutManager(RecyclerActivity.this));
//                        CustomAdapter mAdapter =new CustomAdapter();
//                        mRecyclerView.setAdapter(mAdapter);
//                    }
                }
            });
        }
        @Override
        public int getItemCount() {
            return nama_buah.length;
        }
    }
    private class CustomHolder extends RecyclerView.ViewHolder {
        //TODO pengenalan
        TextView mNamaBuah;
        ImageView mImageView;
        public CustomHolder(View itemView) {
            super(itemView);
            mNamaBuah = itemView.findViewById(R.id.textView);
            mImageView = itemView.findViewById(R.id.imageView);
        }
    }
}






package com.example.alohamusic;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button button1, button2;
    MediaPlayer mpUkulele, mpDrums;
    int playing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.btnUkelele);
        button2 = findViewById(R.id.btnDrums);

        button1.setOnClickListener(Ukulele);
        button2.setOnClickListener(Drums);

        mpUkulele = MediaPlayer.create(this, R.raw.ukulele);
        mpDrums = MediaPlayer.create(this, R.raw.drums);
        playing = 0;
    }

    // Ukulele Button Click Listener
    Button.OnClickListener Ukulele = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(playing) {
                case 0:
                    mpUkulele.start();
                    playing = 1;
                    button1.setText(R.string.pause_ukulele_song);
                    button2.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mpUkulele.pause();
                    playing = 0;
                    button1.setText(R.string.btnUkelele);
                    button2.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };

    // Drums Button Click Listener
    Button.OnClickListener Drums = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(playing) {
                case 0:
                    mpDrums.start();
                    playing = 1;
                    button2.setText(R.string.pause_drums_song);
                    button1.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mpDrums.pause();
                    playing = 0;
                    button2.setText(R.string.btnDrums);
                    button1.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };
}

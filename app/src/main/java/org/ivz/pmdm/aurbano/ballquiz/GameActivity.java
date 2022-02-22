package org.ivz.pmdm.aurbano.ballquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mediaPlayer = MediaPlayer.create(this, R.raw.gametheme);

        final BouncingBallInside bouncingballi = new BouncingBallInside(GameActivity.this);
        setContentView(bouncingballi);

        new CountDownTimer(15000, 1000) {
            public void onTick(long millisUntilFinished) {
                mediaPlayer.start();
            }

            public void onFinish() {
                mediaPlayer.stop();
                Intent intent = new Intent(GameActivity.this, ResultActivity.class);
                startActivity(intent);
            }
        }.start();
    }
}
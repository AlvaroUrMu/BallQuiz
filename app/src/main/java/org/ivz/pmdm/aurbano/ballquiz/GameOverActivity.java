package org.ivz.pmdm.aurbano.ballquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameOverActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private Button btRetry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);

        initialize();

        mediaPlayer.start();

        btRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameOverActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initialize() {
        btRetry = findViewById(R.id.btRetry);

        mediaPlayer = MediaPlayer.create(this, R.raw.sadtrombone);
    }
}
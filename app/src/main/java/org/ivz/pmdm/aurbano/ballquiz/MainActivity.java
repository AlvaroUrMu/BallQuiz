package org.ivz.pmdm.aurbano.ballquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static int mode;
    private Button btEasy, btMedium, btHard;
    private MediaPlayer btSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

        btEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mode = 1;
                btSound.start();
                Intent iEasy = new Intent(MainActivity.this, GameActivity.class);
                startActivity(iEasy);
            }
        });

        btMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mode = 2;
                btSound.start();
                Intent iMedium = new Intent(MainActivity.this, GameActivity.class);
                startActivity(iMedium);
            }
        });

        btHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mode = 3;
                btSound.start();
                Intent iHard = new Intent(MainActivity.this, GameActivity.class);
                startActivity(iHard);
            }
        });
    }

    public void initialize() {
        btEasy = findViewById(R.id.btEasy);
        btMedium = findViewById(R.id.btMedium);
        btHard = findViewById(R.id.btHard);

        btSound = MediaPlayer.create(this, R.raw.menu_click_06);
    }
}
package org.ivz.pmdm.aurbano.ballquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class VictoryActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    private MediaPlayer mediaPlayer;
    private Button btBack, btPhoto;
    private ImageView ivImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_victory);

        initialize();

        mediaPlayer.start();

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VictoryActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });
    }

    private void initialize() {
        btBack = findViewById(R.id.btBack);
        btPhoto = findViewById(R.id.btPhoto);

        ivImage = findViewById(R.id.ivImage);
        ivImage.setVisibility(View.GONE);

        mediaPlayer = MediaPlayer.create(this, R.raw.victorytrumpetfanfare);
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        } catch (ActivityNotFoundException e) {
            // display error state to the user
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ivImage.setVisibility(View.VISIBLE);
            btPhoto.setVisibility(View.GONE);
            ivImage.setImageBitmap(imageBitmap);
        }
    }
}
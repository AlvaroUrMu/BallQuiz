package org.ivz.pmdm.aurbano.ballquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ResultActivity extends AppCompatActivity {

    private EditText etResult;
    private Button btResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        initialize();

        btResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.valueOf(etResult.getText().toString()) != BouncingBallInside.nBalls) {
                    Intent intent = new Intent(ResultActivity.this, GameOverActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(ResultActivity.this, VictoryActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void initialize() {
        etResult = findViewById(R.id.etResult);
        btResult = findViewById(R.id.btResult);
    }
}
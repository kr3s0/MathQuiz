package com.example.mathquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button novaIgraAButton;
    private Button novaIgraBButton;
    private Button pravilaIgreButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.novaIgraAButton = findViewById(R.id.novaIgraAButton);
        this.novaIgraBButton = findViewById(R.id.novaIgraBButton);
        this.pravilaIgreButton = findViewById(R.id.pravilaIgreButton);

        this.novaIgraAButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(NovaIgraAActivity.dajIntentNovaIgraA(MainActivity.this,1000));
            }
        });
        this.novaIgraBButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(NovaIgraAActivity.dajIntentNovaIgraA(MainActivity.this,10000));
            }
        });
    }
}

package com.example.mathquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NovaIgraAActivity extends AppCompatActivity {
    private String[] operacije = new String[]{"+","-","*","/"};
    private static final String RASPON_KEY = "rasponkeyindex";
    private static final String BROJ1_KEY = "broj1key";
    private static final String BROJ2_KEY = "broj2key";
    private static final String BROJAC_KEY = "brojackey";
    private static final String ZNAK_KEY = "znakkey";
    private static final String REZULTAT_KEY = "rezultatkey";
    private static final String ODGOVOR_USERA_KEY = "odgovoruserakey";

    private TextView textBroj1;
    private TextView textBroj2;
    private TextView textOperacija;
    private Button odgovorButton;
    private int brojac;
    private int raspon;
    private int broj1;
    private int broj2;
    private String znak;
    private int rezultat;

    private int odgovorUsera;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //Treba provjeriti koja varijabla nije setovana, pa nju ne treba slati
        outState.putInt(BROJ1_KEY,this.broj1);
        outState.putInt(BROJ2_KEY,this.broj2);
        outState.putInt(BROJAC_KEY,this.brojac);
        outState.putString(ZNAK_KEY,this.znak);
        outState.putInt(REZULTAT_KEY,this.rezultat);
        outState.putInt(ODGOVOR_USERA_KEY,this.odgovorUsera);
        outState.putInt(RASPON_KEY,this.raspon);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_igra_a);

        this.raspon = getIntent().getIntExtra(RASPON_KEY,1000);
        this.textBroj1 = findViewById(R.id.textBroj1);
        this.textBroj2 = findViewById(R.id.textBroj2);
        this.textOperacija = findViewById(R.id.textViewOperacija);
        this.brojac = 0;
        this.odgovorButton = findViewById(R.id.odgovorButton);

        generisiNovo();

        if(savedInstanceState != null){
            //treba provjeriti koja varijabla nije setovana, pa nju ne treba dodjeljivati
            this.raspon = savedInstanceState.getInt(RASPON_KEY);
        }

        this.odgovorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                odgovorUsera = Integer.parseInt(((EditText)findViewById(R.id.userOdgovorRezultat)).getText().toString());
                if(odgovorUsera == rezultat){
                    Toast.makeText(NovaIgraAActivity.this,"Tocan odgovor",Toast.LENGTH_LONG).show();
                    generisiNovo();
                    brojac++;
                }
                else{
                    Toast.makeText(NovaIgraAActivity.this,"Netocan odgovor",Toast.LENGTH_LONG).show();
                    generisiNovo();
                    brojac++;
                }
            }
        });

    }

    public static Intent dajIntentNovaIgraA(Context packageContext,int raspon){
        Intent i = new Intent(packageContext,NovaIgraAActivity.class);
        i.putExtra(RASPON_KEY,raspon);
        return i;
    }

    private static int dajRezultat(int broj1,int broj2,String znak){
        switch (znak){
            case "+":
                return broj1+broj2;
            case "-":
                return  broj1-broj2;
            case "*":
                return broj1*broj2;
            case "/":
                return broj1/broj2;
        }
        return 0;
    }

    private void generisiNovo(){
        NovaIgraAActivity.this.broj1 = (int)(Math.random()*raspon + 1);
        NovaIgraAActivity.this.broj2 = (int)(Math.random()*raspon + 1);
        NovaIgraAActivity.this.znak = NovaIgraAActivity.this.operacije[(int)(Math.random()*4)];
        NovaIgraAActivity.this.textBroj1.setText(String.valueOf(NovaIgraAActivity.this.broj1));
        NovaIgraAActivity.this.textOperacija.setText(NovaIgraAActivity.this.znak);
        NovaIgraAActivity.this.textBroj2.setText(String.valueOf(NovaIgraAActivity.this.broj2));
        NovaIgraAActivity.this.rezultat = dajRezultat(NovaIgraAActivity.this.broj1,NovaIgraAActivity.this.broj2,NovaIgraAActivity.this.znak);
    }
}

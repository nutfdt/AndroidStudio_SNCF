package com.example.mysncf_250;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btRerA, btRerB, btRerC, btRerD, btRerE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Faire le lien entre objets de prog et objets graphiques

        this.btRerA = (ImageButton) findViewById(R.id.idRerA);
        this.btRerB = (ImageButton) findViewById(R.id.idRerB);
        this.btRerC = (ImageButton) findViewById(R.id.idRerC);
        this.btRerD = (ImageButton) findViewById(R.id.idRerD);
        this.btRerE = (ImageButton) findViewById(R.id.idRerE);

        // Rendre les boutons images écoutables

        this.btRerA.setOnClickListener(this);
        this.btRerB.setOnClickListener(this);
        this.btRerC.setOnClickListener(this);
        this.btRerD.setOnClickListener(this);
        this.btRerE.setOnClickListener(this);

        // Initialisation des enquêtes
        SNCF.initialiser();
    }

    @Override
    public void onClick(View v) {
        String rer = "";
        switch (v.getId()){
            case R.id.idRerA : rer = "rerA";
                break;
            case R.id.idRerB : rer = "rerB";
                break;
            case R.id.idRerC : rer = "rerC";
                break;
            case R.id.idRerD : rer = "rerD";
                break;
            case R.id.idRerE : rer = "rerE";
                break;
        }
        Intent unIntent = new Intent(this, Inscription.class);
        unIntent.putExtra("rer", rer);
        this.startActivity(unIntent);
    }
}
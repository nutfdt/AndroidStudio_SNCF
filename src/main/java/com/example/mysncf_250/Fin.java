package com.example.mysncf_250;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Fin extends AppCompatActivity implements View.OnClickListener {

    private TextView txtResultat;
    private ImageView ivSmiley;
    private ListView lvListe;
    private Button btRetour;
    private String rer, email;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin);

        this.btRetour = (Button) findViewById(R.id.idRetour);
        this.lvListe = (ListView) findViewById(R.id.idListe);
        this.ivSmiley = (ImageView) findViewById(R.id.idSmiley);
        this.txtResultat = (TextView) findViewById(R.id.idMoyenne);

        if (this.getIntent().getStringExtra("rer") != null) {
            this.rer = this.getIntent().getStringExtra("rer");
            this.email = this.getIntent().getStringExtra("email");
        }
        this.btRetour.setOnClickListener(this);

        //  Remplir le txt moyenne
        float moy = SNCF.getEnquete(this.rer).moyenne(this.email);
        this.txtResultat.setText("Votre moyenne est de : " + moy);
        if (moy < 10) {
            this.ivSmiley.setImageResource(R.drawable.smiley_3);
        } else if (moy < 14) {
            this.ivSmiley.setImageResource(R.drawable.smiley_2);
        } else {
            this.ivSmiley.setImageResource(R.drawable.smiley_1);
        }
        ArrayList<String> lesParticipants = new ArrayList<>();
        for (Candidat unCandidat : SNCF.getEnquete(this.rer).getLesCandidats().values()) {
            lesParticipants.add(unCandidat.getNom() + "  " + unCandidat.getPrenom() +
                    "  " + unCandidat.moyenne());
        }
        ArrayAdapter unAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                lesParticipants);
        this.lvListe.setAdapter(unAdapter);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.idRetour) {
            Intent unIntent = new Intent(this, MainActivity.class);
            this.startActivity(unIntent);
        }
    }
}
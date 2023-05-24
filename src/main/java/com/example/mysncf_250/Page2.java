package com.example.mysncf_250;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class Page2 extends AppCompatActivity implements View.OnClickListener{
    private RadioGroup rgProprete, rgInformation;
    private Button btSuivant;
    private String rer, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        this.rgProprete = (RadioGroup) findViewById(R.id.idProprete);
        this.rgInformation = (RadioGroup) findViewById(R.id.idInformation);
        this.btSuivant = (Button)  findViewById(R.id.idSuivant2);
        this.btSuivant.setOnClickListener(this);
        if (this.getIntent().getStringExtra("rer")!=null)
        {
            this.rer = this.getIntent().getStringExtra("rer");
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.idSuivant2)
        {
            int score = 0;
            switch (this.rgProprete.getCheckedRadioButtonId()){
                case R.id.idProprete1: score =16;
                    break;
                case R.id.idProprete2: score =12;
                    break;
                case R.id.idProprete3: score =8;
                    break;
            }
            //ajouter la réponse du candidat dans l'enquete
            SNCF.getEnquete(this.rer).ajouterReponse("Proprete", score, this.email);
            switch (this.rgInformation.getCheckedRadioButtonId()) {
                case R.id.idInformation1:
                    score = 16;
                    break;
                case R.id.idInformation2:
                    score = 12;
                    break;
                case R.id.idInformation3:
                    score = 8;
                    break;
            }
            SNCF.getEnquete(this.rer).ajouterReponse("Information", score, this.email);
            Intent unIntent = new Intent(this, Fin.class);
            unIntent.putExtra("rer", rer);
            unIntent.putExtra("email", email);
            this.startActivity(unIntent);
        }
    }
}
package com.ensa.exercice2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText nom, surface, adresse, nbpiece;
    private TextView total, base, supplementaire;
    private Button calcul;
    private CheckBox piscine;
    private double t = 0;
    private double b = 0;
    private double s = 0;
    private double nb, sur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nom = findViewById(R.id.nom);
        surface = findViewById(R.id.surface);
        adresse = findViewById(R.id.adresse);
        nbpiece = findViewById(R.id.nbpiece);
        calcul = findViewById(R.id.calcul);
        piscine = findViewById(R.id.piscine);

        total = findViewById(R.id.total);
        base = findViewById(R.id.base);
        supplementaire = findViewById(R.id.supplementaire);


        calcul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    if (!surface.getText().toString().isEmpty() && !nbpiece.getText().toString().isEmpty()) {

                        sur = Integer.parseInt(surface.getText().toString());
                        nb = Integer.parseInt(nbpiece.getText().toString());


                        if (piscine.isChecked()) {
                            s = nb * 50 + 100;
                        } else {
                            s = nb * 50;
                        }
                        b = sur * 2;
                        t = b + s;


                        base.setText("Impôt de base: " + String.valueOf(b));
                        supplementaire.setText("Impôt supplémentaire: " + String.valueOf(s));
                        total.setText("Impôt Total: " + String.valueOf(t));
                    } else {
                        base.setText("Veuillez remplir tous les champs.");
                    }

            }
        });
    }
}

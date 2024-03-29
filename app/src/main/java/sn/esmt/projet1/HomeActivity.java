package sn.esmt.projet1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    private Button Inscriptionbt;
    private Button Visualisationbt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Inscriptionbt = (Button) findViewById(R.id.Inscriptionbt);
        Visualisationbt= (Button) findViewById(R.id.Visualisationbt);

        Inscriptionbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(HomeActivity.this,InscriptionActivity.class);
                startActivity(intent);
            }
        });

        Visualisationbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(HomeActivity.this,ListeEtudiantActivity.class);
                startActivity(intent);
            }
        });

    }
}
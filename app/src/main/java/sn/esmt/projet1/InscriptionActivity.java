package sn.esmt.projet1;

import androidx.appcompat.app.AppCompatActivity;

import android.net.DnsResolver;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sn.esmt.projet1.http.Api;
import sn.esmt.projet1.http.EtudiantResponce;

public class InscriptionActivity extends AppCompatActivity {

    private Button Retourbt ;
    private EditText Matriculetxt;
    private EditText nomtxt;
    private EditText prenomtxt;
    private EditText adrtxt;
    private EditText teltxt;
    private  EditText fraistxt;
    private Button inscrirebt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        Retourbt = (Button) findViewById(R.id.Retourbt);
        Matriculetxt =(EditText) findViewById(R.id.Matriculetxt);
        nomtxt =(EditText) findViewById(R.id.nomtxt);
        prenomtxt =(EditText) findViewById(R.id.prenomtxt);
        adrtxt =(EditText) findViewById(R.id.adrtxt);
        teltxt =(EditText) findViewById(R.id.teltxt);
        fraistxt =(EditText) findViewById(R.id.fraistxt);
        inscrirebt =(Button) findViewById(R.id.inscrirebt);

        Retourbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InscriptionActivity.this,LoginActivity.class);
            }
        });

        inscrirebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://10.0.2.2:8082")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Api api = retrofit.create(Api.class);
                //Creation d'un objet a ajouter dans la base
                EtudiantResponce e = new EtudiantResponce();
                e.setMat(Matriculetxt.getText().toString());
                e.setNom(nomtxt.getText().toString());
                e.setPrenom(prenomtxt.getText().toString());
                e.setAdr(adrtxt.getText().toString());
                e.setFrais(Double.parseDouble(fraistxt.getText().toString()));
                e.setTel(Integer.parseInt(teltxt.getText().toString()));
                Call<EtudiantResponce> callSave = api.saveEtudiant(e);

                //Appel de l"Api
                Call<EtudiantResponce> callsave = api.saveEtudiant(e);
                callsave.enqueue(new Callback<EtudiantResponce>() {
                    @Override
                    public void onResponse(Call<EtudiantResponce> call, Response<EtudiantResponce> response) {
                        Toast.makeText(InscriptionActivity.this,
                                "Etudiant inscrit avec succes", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<EtudiantResponce> call, Throwable t) {
                        Toast.makeText(InscriptionActivity.this,
                                "Impossible d'acceder au serveur", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
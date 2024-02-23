package sn.esmt.projet1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText comptetxt;
    private EditText passwordtxt;
    private Button Loginbt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //recuperation des valeurs saisies
        comptetxt = (EditText) findViewById(R.id.comptetxt);
        passwordtxt= (EditText) findViewById(R.id.passwordtxt);
        //recuperation de l'id du bouton login
        Loginbt=(Button) findViewById(R.id.Loginbt);

        Loginbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email= comptetxt.getText().toString();
                String pwd = passwordtxt.getText().toString();
                if(email.isEmpty() || pwd.isEmpty()){
                    Toast.makeText(LoginActivity.this,
                            "Veuillez renseigner tous les champs",Toast.LENGTH_LONG).show();
                }
                else{
                    if(email.equals("esmt@esmt.sn") && pwd.equals("123")){
                        Intent i = new Intent(LoginActivity.this,HomeActivity.class);
                        startActivity(i);
                    }
                    else{
                        Toast.makeText(LoginActivity.this,
                                "Email ou mot de passe incorrect",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
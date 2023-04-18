package com.example.aula050323;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(getApplicationContext(),home.class);
            startActivity(intent);
            finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int gray = Color.GRAY;
        TextView gotoregister;
        gotoregister = findViewById(R.id.gotoregister);
        MaterialButton login = findViewById(R.id.botao);
        EditText user, senha;
        user = findViewById(R.id.userbox);
        senha = findViewById(R.id.passwordbox);
        ProgressBar barra = findViewById(R.id.barra);


        gotoregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),register.class);
                startActivity(intent);
                finish();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userstring, senhastring;
                userstring = user.getText().toString();
                senhastring = senha.getText().toString();

                if(userstring.isEmpty()){
                    Toast.makeText(MainActivity.this, "usuario nulo", Toast.LENGTH_SHORT).show();
                }
                else if (senhastring.isEmpty()){
                    Toast.makeText(MainActivity.this,"senha nula",Toast.LENGTH_SHORT).show();
                }
                else {
                    barra.setVisibility(View.VISIBLE);
                    mAuth.signInWithEmailAndPassword(userstring, senhastring)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Log.d("tag4", "signInWithEmail:success");
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        Toast.makeText(MainActivity.this, "Authentication succeeded.",
                                                Toast.LENGTH_SHORT).show();
                                        barra.setVisibility(View.GONE);
                                        Intent intent = new Intent(getApplicationContext(),home.class);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Log.w("tag3", "signInWithEmail:failure", task.getException());
                                        Toast.makeText(MainActivity.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();
                                        barra.setVisibility(View.GONE);
                                    }
                                }
                            });
                }

            }
        });


    }


}
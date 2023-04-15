package com.example.aula050323;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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

public class register extends AppCompatActivity {
    EditText txtEmail,txtPass,checkPass;
    MaterialButton rbutton;
    TextView gotologin;
    FirebaseAuth mAuth;
    ProgressBar pbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_register);

        txtEmail = findViewById(R.id.userbox);
        txtPass = findViewById(R.id.passwordbox);
        pbar = findViewById(R.id.barra);
        checkPass = findViewById(R.id.checkpassword);
        rbutton = findViewById(R.id.botao);
        gotologin = findViewById(R.id.backtolog);
        gotologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(),MainActivity.class);
                      startActivity(intent2);
                      finish();
            }
        });
        rbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email, password, rptpass;
                email = txtEmail.getText().toString();
                password = String.valueOf(txtPass.getText());
                rptpass = String.valueOf(checkPass.getText());
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(register.this,"no user",Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(password)){
                    Toast.makeText(register.this,"no password",Toast.LENGTH_SHORT).show();
                }
                else if (!(rptpass.equals(password))) {
                    Toast.makeText(register.this,"senhas não batem",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(register.this,"usuario registrado",Toast.LENGTH_SHORT).show();
                    pbar.setVisibility(View.VISIBLE);
                    mAuth.createUserWithEmailAndPassword(email,password)
                         .addOnCompleteListener(register.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d("TAG", "createUserWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    pbar.setVisibility(View.GONE);

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("NTAG", "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(register.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    pbar.setVisibility(View.GONE);
                                }
                            }
                        });
                    }
                }

        });

    }
}
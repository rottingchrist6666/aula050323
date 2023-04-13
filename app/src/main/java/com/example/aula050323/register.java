package com.example.aula050323;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class register extends AppCompatActivity {
    EditText txtEmail,txtPass,checkPass;
    MaterialButton rbutton;
    TextView gotologin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        txtEmail = findViewById(R.id.userbox);
        txtPass = findViewById(R.id.passwordbox);
        checkPass = findViewById(R.id.checkpassword);
        rbutton = findViewById(R.id.botao);
        gotologin = findViewById(R.id.backtolog);

        rbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email, password;
                email = txtEmail.getText().toString();
                password = String.valueOf(txtPass.getText());
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(this, "no user", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
package com.example.aula050323;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int gray = Color.GRAY;
        TextView gotoregister;
        gotoregister = findViewById(R.id.gotoregister);
        MaterialButton login = findViewById(R.id.botao);
        EditText user, senha;
        user = findViewById(R.id.userbox);
        senha = findViewById(R.id.passwordbox);
        String userstring, senhastring;
        gotoregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),register.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
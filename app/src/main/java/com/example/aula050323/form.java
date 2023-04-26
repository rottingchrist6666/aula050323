package com.example.aula050323;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class form extends AppCompatActivity {
    EditText f1,f2,f3,f4;
    MaterialButton b1,b2;
    String nome,idade,cpf,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        f1 = findViewById(R.id.form1);
        f2 = findViewById(R.id.form2);
        f3 = findViewById(R.id.form3);
        f4 = findViewById(R.id.form4);
        b1 = findViewById(R.id.botao1);
        b2 = findViewById(R.id.botao2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nome = f1.getText().toString();
                cpf = f2.getText().toString();
                idade = f3.getText().toString();
                email = f4.getText().toString();
                database db = new database(form.this);

                if (nome.isEmpty() || cpf.isEmpty() || idade.isEmpty() || email.isEmpty())
                    Toast.makeText(form.this, "cadastro incompleto", Toast.LENGTH_SHORT).show();
            }
                else {


            }
        });

    }
}
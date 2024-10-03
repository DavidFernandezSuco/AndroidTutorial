package com.example.apptutorial.intents;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.apptutorial.R;

public class IntentImplicito extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intent_implicito);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText textComida = findViewById(R.id.editTextComida);
        EditText textBebida = findViewById(R.id.editTextBebida);
        //Recuperar los datos: crear un obejeto Bundle y usar el metodo getIntent().getExtras()
        Bundle extras = getIntent().getExtras();

        String textoPrueba = extras.getString("prueba");
        String comida = extras.getString("comida");
        String bebida = extras.getString("bebida");



        textComida.setText(comida);
        textBebida.setText(bebida);


        Log.d("prueba", textoPrueba);

    }
}
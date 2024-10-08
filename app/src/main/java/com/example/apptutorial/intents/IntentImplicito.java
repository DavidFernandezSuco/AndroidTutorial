package com.example.apptutorial.intents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

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

        //INTENT IMPLICITO NAVEGADOR
        //recuperar el imageButton de la vista usando el metodo findViewById para buscar un elemento en la vista por ID
        ImageView imageButton = findViewById(R.id.imageButton);

        //añadir un listener
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent para abrir un navegador
                String url = "https://www.flaticon.es/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);

                //intent crear alarma
                //Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                //.putExtra(AlarmClock.EXTRA_MESSAGE, "Alarma");
                //.putExtra(AlarmClock.EXTRA_HOUR, 7);
                //.putExtra(AlarmClock.EXTRA_MINUTES, 10);
                //startActivity(intent);
            }

        });
    }
}
package com.example.apptutorial;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.apptutorial.intents.IntentExplicito;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Obtener boton de la vista usando el metodo findViewById para buscar un elemento en la vista por ID
        Button btnIntent = findViewById(R.id.buttonIntent);

        //añadir un listener al boton usando el objeto de antes
        btnIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*crear intent explicito para pasar de actividad creando un objeto de la clase Intent
                * pasando por parametros la clase en la que estamos y la axtividad a la que queremos ir*/
                Intent intentExplicito = new Intent(MainActivity.this, IntentExplicito.class);

                //Hay que lanzar el intent
                startActivity(intentExplicito);

            }
        });





    }
}
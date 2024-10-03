package com.example.apptutorial.intents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.apptutorial.R;

public class IntentExplicito extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intent_explicito);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Obtener boton de la vista usando el metodo findViewById para buscar un elemento en la vista por ID
        Button btnComprar = findViewById(R.id.buttonComprar);

        //recuperar los datos de los editText
        EditText editTextComprar = findViewById(R.id.editTextComida);
        EditText editTextBebida = findViewById(R.id.editTextBebida);

        //Anñadir un listener al boton usando el objeto de antes
        btnComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(IntentExplicito.this, IntentImplicito.class);
                //añadir datos al intent
                i.putExtra("prueba", "hamburguesa");


                i.putExtra("comida", editTextComprar.getText().toString());
                i.putExtra("bebida", editTextBebida.getText().toString());

                startActivity(i);
            }

        });

}
}
package com.example.david_fernandez_suco_pmdm_tarea1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginCorrecto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_correcto);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Recuperar el nombre de usuario del putExtra de inicio de sesion
        String nombre = getIntent().getStringExtra("nombre");

        //recuperar el textView de bienvenida y añadir el nombre de usuario
        TextView textViewBienvenida = findViewById(R.id.textViewBienvenida);
        textViewBienvenida.setText("Bienvenido " + nombre);

        //obtener el imagebutton
        ImageButton imageButton = findViewById(R.id.imageButton);
        //ir a la url indicada si se clica en el imageButton con un intent implicito
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentURL = new Intent(Intent.ACTION_VIEW, android.net.Uri.parse("https://www.tutorialspoint.com/android/android_intents_filters.htm%E2%80%9D"));
                startActivity(intentURL);
            }
        });
        //recuperar el boton Poner Alarma
        Button buttonAlarma = findViewById(R.id.buttonAlarma);
        //ir a la actividad crear alarma si se clica en el boton poner alarma
        buttonAlarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginCorrecto.this, CrearAlarma.class);
                startActivity(intent);
            }
        });

    }
}
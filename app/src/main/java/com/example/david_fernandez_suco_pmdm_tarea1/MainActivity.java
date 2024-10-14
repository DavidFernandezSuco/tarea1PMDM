package com.example.david_fernandez_suco_pmdm_tarea1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

        //obtener los botones a través de sus ids
        Button buttonIniciarSesion = findViewById(R.id.buttonIniciarSesion);
        Button buttonCredenciales = findViewById(R.id.buttonCredenciales);


        //obtener los editText a través de sus ids
        EditText editTextNombre = findViewById(R.id.editTextNombre);
        EditText editTextContraseña = findViewById(R.id.editTextContraseña);

        //

        //añadir un listener al boton iniciar sesion
        buttonIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //comprobar que el texto introducido en los dos editTexts corresponden a admin
                if (editTextNombre.getText().toString().equals("admin")
                        && editTextContraseña.getText().toString().equals("admin")) {
                    //si se cumple la condicion ir a la siguiente actividad a través de un intent explicito
                    Intent inicioSesion = new Intent(MainActivity.this, LoginCorrecto.class);
                    //pasar el nombre del usuario a la siguiente actividad
                    inicioSesion.putExtra("nombre", editTextNombre.getText().toString());
                    startActivity(inicioSesion);
                } else {
                    //si no se cumple mostrar el mensaje correspondiente
                    Toast.makeText(MainActivity.this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}





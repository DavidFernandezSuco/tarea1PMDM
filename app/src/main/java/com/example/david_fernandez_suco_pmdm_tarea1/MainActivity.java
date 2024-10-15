package com.example.david_fernandez_suco_pmdm_tarea1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //variables globales para nombre de usuario y contraseña
    String nombre = "admin";
    String contrasena = "admin";

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

        //crear activity result launcher que recupere el nombre y la contraseña introducidos
        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        //recuperar el nombre y la contraseña introducidos
                        nombre = result.getData().getStringExtra("nombre");
                        contrasena = result.getData().getStringExtra("contraseña");
                    }
                });

        //añadir un listener al boton iniciar sesion
        buttonIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //comprobar que el texto introducido en los dos editTexts corresponden las variables globales
                if (editTextNombre.getText().toString().equals(nombre)
                        && editTextContraseña.getText().toString().equals(contrasena)) {
                    //si se cumple la condicion ir a la siguiente actividad a través de un intent explicito
                    Intent inicioSesion = new Intent(MainActivity.this, LoginCorrecto.class);
                    //pasar el nombre del usuario a la siguiente actividad
                    inicioSesion.putExtra("nombre", editTextNombre.getText().toString());
                    //iniciar el intent
                    startActivity(inicioSesion);
                } else {
                    //si no se cumple mostrar el mensaje correspondiente
                    Toast.makeText(MainActivity.this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //listener al clicar en el boton credenciales
        buttonCredenciales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //lanzar el activity result launcher
                Intent intentCredenciales = new Intent(MainActivity.this, ModificarCredenciales.class);
                activityResultLauncher.launch(intentCredenciales);
            }
        });
    }
}





package com.example.david_fernandez_suco_pmdm_tarea1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ModificarCredenciales extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_modificar_credenciales);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //recuperar el editText Nombre
        EditText editTextNuevoNombre = findViewById(R.id.editTextNuevoNombre);
        //recuperar el editText Contrasena
        EditText editTextNuevaContraseña = findViewById(R.id.editTextNuevaContraseña);
        //recuperar el boton Guardar Cambios
        Button buttonCredenciales = findViewById(R.id.buttonGuardarCambios);
        //listener al clicar en el boton modificar credenciales
        buttonCredenciales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //lanzar el activity result launcher
                Intent intentModificaarCredenciales = new Intent(ModificarCredenciales.this, MainActivity.class);

                //enviar los datos a la clase MainActivity con putExtra
                intentModificaarCredenciales.putExtra("nombre", editTextNuevoNombre.getText().toString());
                intentModificaarCredenciales.putExtra("contraseña", editTextNuevaContraseña.getText().toString());

                setResult(RESULT_OK, intentModificaarCredenciales);
                finish();
            }
        });

    }
}
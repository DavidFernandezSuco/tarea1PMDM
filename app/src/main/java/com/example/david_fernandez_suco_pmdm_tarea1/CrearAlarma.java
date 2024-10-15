package com.example.david_fernandez_suco_pmdm_tarea1;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CrearAlarma extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_crear_alarma);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //recuperar el boton Poner Alarma
        Button buttonAlarma = findViewById(R.id.buttonCrearAlarma);
        //recuperar variables de los editText
        EditText editTextAlarmaNombre = findViewById(R.id.editTextAlarmaNombre);
        EditText editTextHoraAlarma = findViewById(R.id.editTextHoraAlarma);
        EditText editTextMinutosAlarma = findViewById(R.id.editTextMinutosAlarma);

        //listener al clicar en el boton crear alarma
        buttonAlarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //variables para setear en la alarma
                String nombreAlarma = editTextAlarmaNombre.getText().toString();
                String horaAlarma = editTextHoraAlarma.getText().toString();
                String minutosAlarma = editTextMinutosAlarma.getText().toString();

                //intent para crear alarma con los datos introducidos
                Intent alarmaIntent = new Intent(AlarmClock.ACTION_SET_ALARM);
                alarmaIntent.putExtra(AlarmClock.EXTRA_HOUR, Integer.parseInt(horaAlarma));
                alarmaIntent.putExtra(AlarmClock.EXTRA_MINUTES, Integer.parseInt(minutosAlarma));
                alarmaIntent.putExtra(AlarmClock.EXTRA_MESSAGE, nombreAlarma);
                startActivity(alarmaIntent);



            }
        });
    }
}
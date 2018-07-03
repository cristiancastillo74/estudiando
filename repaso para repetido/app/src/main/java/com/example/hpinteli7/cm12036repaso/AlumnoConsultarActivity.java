package com.example.hpinteli7.cm12036repaso;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AlumnoConsultarActivity extends Activity{
    ControlBD helper;
    EditText editCarnet;
    EditText editNombre;
    EditText editApellido;
    EditText editSexo;
    EditText editMatganadas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno_consultar);
        helper = new ControlBD(this);
        editCarnet = (EditText) findViewById(R.id.editCarnet);
        editNombre = (EditText) findViewById(R.id.editNombre);
        editApellido = (EditText) findViewById(R.id.editApellido);
        editSexo = (EditText) findViewById(R.id.editSexo);
        editMatganadas = (EditText) findViewById(R.id.editMatganadas);
    }

    public void consultarAlumno(View v) {
        helper.abrir();
        Alumno alumno = helper.consultarAlumno(editCarnet.getText().toString());
        helper.cerrar();
        if(alumno == null)
            Toast.makeText(this, "Alumno con carnet " + editCarnet.getText().toString() +
                    " no encontrado", Toast.LENGTH_LONG).show();
        else{
            editNombre.setText(alumno.getNombre());
            editApellido.setText(alumno.getApellido());
            editSexo.setText(alumno.getSexo());
            editMatganadas.setText(String.valueOf(alumno.getMatganadas()));
        }
    }
    public void limpiarTexto(View v){
        editCarnet.setText("");
        editNombre.setText("");
        editApellido.setText("");
        editSexo.setText("");
        editMatganadas.setText("");
    }
}

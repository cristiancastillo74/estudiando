package com.example.hpinteli7.cm12036repaso;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

public class BaseDatosCarnetActivity extends ListActivity{

    String[] menu={"Tabla Alumno","Tabla Nota","Tabla Materia","LLenar Base de Datos"};
    String[] activities={"AlumnoMenuActivity","NotaMenuActivity","MateriaMenuActivity"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_datos_carnet);
    }

    @Override
    protected void onListItemClick(ListView l,View v,int position,long id){
        super.onListItemClick(l, v, position, id);
        if(position!=3){
            String nombreValue=activities[position];
            try{
                Class<?> clase=Class.forName("com.example.hpinteli7.cm12036repaso."+nombreValue);
                Intent inte = new Intent(this,clase);
                this.startActivity(inte);

            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }
        }else{
//CODIGO PARA LLENAR BASE DE DATOS
        }
    }
}

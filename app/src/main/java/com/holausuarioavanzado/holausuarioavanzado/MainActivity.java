package com.holausuarioavanzado.holausuarioavanzado;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

        private EditText txtNombre;
        private RadioGroup idiomas;
        private RadioButton español, ingles;
        Spinner spinner;
        ArrayAdapter<String> aaColor;
        String [] opcColor = new String [] {"Escoje Color", "Azul","Verde","Amarillo" };
        private Button btnAceptar;
        private CheckBox condicionesAA;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ingles=(RadioButton)findViewById(R.id.rbtn_ingles);
        español=(RadioButton)findViewById(R.id.español);
        idiomas=(RadioGroup)findViewById(R.id.radioBtnIdiomas);
        btnAceptar=(Button)findViewById(R.id.aceptar);
        btnAceptar.setEnabled(false);
        spinner=(Spinner)findViewById(R.id.spnColor);
        condicionesAA=(CheckBox)findViewById(R.id.condiciones);

        //lo del checkBox true boton operativo false no
        condicionesAA.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                   if(isChecked){
                       btnAceptar.setEnabled(true);
                   }else {
                       btnAceptar.setEnabled(false);
                   }
            }

        });


        aaColor = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opcColor);//PARA PASAR EL COLOR
        spinner.setAdapter(aaColor);//cuando se crea en la pantalla -llenar en tiempo de ejecucion
        //spinner.setOnItemSelectedListener(this);


    }



    public void botonSaludoAvanzado(View v){

        Intent intento = new Intent(MainActivity.this,Saludo_Avanzado.class);
        txtNombre=(EditText)findViewById(R.id.txt_escribirNombre);//entrada de teclado

        //if Toast
        if("".equals(txtNombre.getText().toString().trim())){
            showToast();
            return;
        }

        Bundle bun = new Bundle();

        //para seleccionar el idioma
        String idiomaSeleccionado=null;

        if(R.id.rbtn_ingles==idiomas.getCheckedRadioButtonId()){
           idiomaSeleccionado=getResources().getString(R.string.ingles);//lo busca en la carpeta string-etiqueta
        }else{

            idiomaSeleccionado=getResources().getString(R.string.espanol);//lo busca en la carpeta string-etiqueta
        }
        bun.putString("nombre", idiomaSeleccionado + " " + txtNombre.getText().toString());

        //para ver el color del spinner
        int color=getResources().getColor(R.color.negro);
        String nombreColor= spinner.getSelectedItem().toString();

        if(nombreColor.equals("Azul")){
            color=getResources().getColor(R.color.azul);
            bun.putInt("colores",color);
        }else if(nombreColor.equals("Verde")){
            color=getResources().getColor(R.color.verde);
            bun.putInt("colores",color);
        }else if(nombreColor.equals("Amarillo")){
            color=getResources().getColor(R.color.amarillo);
            bun.putInt("colores",color);
        }else{
            bun.putInt("colores",color);
        }



        intento.putExtras(bun);
        startActivity(intento);

    }

    private void showToast() {
        Context context = getApplicationContext();
        CharSequence text = getResources().getString(R.string.noNameMsg);
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }


    /*public void escogerIdioma(){
        if(español.isChecked()){
             String saludo=String.valueOf("nombre");
        }else if(ingles.isChecked()){
            String Saludo2= String.valueOf("nombre");
        }
    }*/

}

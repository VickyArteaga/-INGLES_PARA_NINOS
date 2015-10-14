package com.holausuarioavanzado.holausuarioavanzado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Saludo_Avanzado extends AppCompatActivity {

        private TextView textoSalida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludo__avanzado);

        textoSalida=(TextView)findViewById(R.id.txt_nombreEntra);
        Bundle bun = this.getIntent().getExtras();
        textoSalida.setText(bun.getString("nombre"));
        textoSalida.setTextColor(bun.getInt("colores"));
    }
}

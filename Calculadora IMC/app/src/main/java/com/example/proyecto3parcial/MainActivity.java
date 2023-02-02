package com.example.proyecto3parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText ete,etp;
    private TextView tvimc;
    private CheckBox metrico,imperial;
    private Switch s;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ete = findViewById(R.id.txt_estatura);
        etp = findViewById(R.id.txt_peso);
        tvimc =findViewById(R.id.tv_imc);
        metrico= findViewById(R.id.checkmetrico);
        imperial= findViewById(R.id.checkimperial);
         s = findViewById(R.id.switchsexo);
         image=findViewById(R.id.ImagenIMC);


    }

    public void sistema(View v){
        if (metrico.isChecked()==false && imperial.isChecked()==false){
            Toast.makeText(getApplicationContext(),"Porfavor seleccione un sistema de medicion ",Toast.LENGTH_SHORT).show();
        }
        validarNumeros();

        if(metrico.isChecked() && imperial.isChecked()){
            Toast.makeText(getApplicationContext(),"Porfavor seleccione solo un sistema de medicion ",Toast.LENGTH_SHORT).show();
        }else if(validarNumeros()==true) {
            if (metrico.isChecked()){
                metrico();
            }else if(imperial.isChecked()){
                imperial();
            }

        }
        imagen();
    }

    public boolean validarNumeros() {
        boolean retorno = true;

        String valore = ete.getText().toString();
        String valorp = etp.getText().toString();


        if (valore.isEmpty() && valorp.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Porfavor ingrese altura y peso ", Toast.LENGTH_SHORT).show();
            retorno = false;
        } else {
            if (valore.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Porfavor ingrese estatura ", Toast.LENGTH_SHORT).show();
                retorno = false;
            } else {
                if (valorp.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Porfavor ingrese peso ", Toast.LENGTH_SHORT).show();
                    retorno = false;
                }
            }
        }

        if (valore.isEmpty() == false && valorp.isEmpty() == false) retorno = true;

        return retorno;
    }

    public void metrico(){
        String valore= ete.getText().toString();
        String valorp= etp.getText().toString();

        double estatura=Double.parseDouble(valore);
        double peso=Double.parseDouble(valorp);

        double IMC= peso/Math.pow(estatura,2);

        tvimc.setText(""+IMC);

    }

    public void imperial(){
        String valore= ete.getText().toString();
        String valorp= etp.getText().toString();

        double estatura=Double.parseDouble(valore);
        double peso=Double.parseDouble(valorp);

        double IMC= (peso* 703)/Math.pow(estatura,2);

        tvimc.setText(""+IMC);
    }

    public void imagen(){
        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    image.setImageResource(R.drawable.imc_mujer);
                }else{
                    image.setImageResource(R.drawable.imc_hombre);
                }
            }
        });
    }
}
package com.example.proyecto3parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityMenu extends AppCompatActivity {

    Button btncal,btnacer,btnser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        btncal=findViewById(R.id.btn_cal);
        btnacer=findViewById(R.id.btn_acer);
        btnser=findViewById(R.id.btn_ser);
    }


    public void abrircalculadora(View v){
        Intent intent = new Intent (MainActivityMenu.this,MainActivity.class);
        startActivity(intent);
    }

    public void abriracerca(View v){
        Intent intent = new Intent (MainActivityMenu.this,MainActivityAcercaDe.class);
        startActivity(intent);
    }

    public void abrirservicio(View v){
        Intent intent = new Intent (MainActivityMenu.this,MainActivityServicio.class);
        startActivity(intent);
    }

}
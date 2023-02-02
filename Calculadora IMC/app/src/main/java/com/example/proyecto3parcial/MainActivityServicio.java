package com.example.proyecto3parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivityServicio extends AppCompatActivity {

    String email = "imccompany@gmail.com";
            String subject = "comunicacion";
    String body = "detalle su mensaje";
            String chooserTitle = "test de comunicacion";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_servicio);
    }

    public void navegar(View view){
        Intent iNavegar= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ricktroy.com/wp-content/uploads/2021/09/imc-formula-calculo.png"));
        startActivity(iNavegar);
    }

    public void comunicarse(View v){
        Uri uri = Uri.parse("mailto:" + email)
                .buildUpon()
                .appendQueryParameter("subject", subject)
                .appendQueryParameter("body", body)
                .build();

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, uri);
        startActivity(Intent.createChooser(emailIntent, chooserTitle));
    }
}
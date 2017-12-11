package com.example.liset.proyec_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PerfilActivity extends AppCompatActivity {
    TextView Codigo, Name, dni,email, call;

    Button btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        Codigo= (TextView)findViewById(R.id.etcodigocard);
        Name= (TextView)findViewById(R.id.etname);
        dni= (TextView)findViewById(R.id.etdni);
        email= (TextView)findViewById(R.id.etcorreo);
        call= (TextView)findViewById(R.id.ettelefono);
        btnback = (Button)findViewById(R.id.btnvolver);


        Intent intent=getIntent();
        Bundle extras=intent.getExtras();
        if (extras!=null){
            String datonombre=(String)extras.get("name");String datolas=(String)extras.get("lastname");
            String datoce=(String)extras.get("celu");
            String datodni=(String)extras.get("dni");
            String datoem=(String)extras.get("email");String datoid=(String)extras.get("id");
            Codigo.setText(datonombre); Name.setText(datonombre  +  datolas);dni.setText(datodni);email.setText(datoem);
            call.setText(datoce);  Codigo.setText(datoid);
        }


        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "Saliendo del Perfil", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(PerfilActivity.this, MostrarActivity.class);
                startActivity(intent);
            }
        });
    }
}

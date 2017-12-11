package com.example.liset.proyec_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

public class MostrarActivity extends AppCompatActivity {

    Button btnconsultar , perfil, cerrar;
    EditText etcodigotarje;
    String monto, id, estado, name,lastname , celular, email, dni;
    TextView Codigo, Monto, Estado,nombre;
    RequestQueue rq;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        rq= Volley.newRequestQueue(this);
        etcodigotarje = (EditText)findViewById(R.id.etcodigotarje);
        btnconsultar = (Button)findViewById(R.id.btnconsultarcod);
        perfil = (Button)findViewById(R.id.perfil);
       cerrar = (Button)findViewById(R.id.btncerrar);

        nombre = (TextView)findViewById(R.id.etnombre);


        Estado= (TextView)findViewById(R.id.etestado);
        Monto= (TextView)findViewById(R.id.etmonto);

        Intent intent=getIntent();
        Bundle extras=intent.getExtras();
        if (extras!=null){
            String datonombre=(String)extras.get("nombre");
            nombre.setText(datonombre);
        }

        btnconsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ConsultaPass("http://54.218.69.196/ejemplologin/obtenersaldo.php?idtarje="+etcodigotarje.getText().toString());
            }
        });

        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MostrarActivity.this, PerfilActivity.class);
                //mandar datos a otro main

                String auxNombre=name.toString();String auxLas=lastname.toString();String auxCel=celular.toString();
                String auxEma=email.toString(); String auxDni=dni.toString();String auxid=id.toString();
                intent.putExtra("name",auxNombre); intent.putExtra("lastname",auxLas);intent.putExtra("celu",auxCel);
                intent.putExtra("email",auxEma);intent.putExtra("dni",auxDni);intent.putExtra("id",auxid);

                startActivity(intent);
                //   nombre.setText(nombres);

            }
        });

       cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "Cerrando Sesion", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MostrarActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
            private void ConsultaPass(String URL) {

                Log.i("url", "" + URL);

                RequestQueue queue = Volley.newRequestQueue(this);
                StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray ja= new JSONArray(response);

                            id = ja.getString(0);
                            monto= ja.getString(1);
                            estado= ja.getString(2);
                            name= ja.getString(3);
                            lastname= ja.getString(4);
                            celular= ja.getString(5);
                            email= ja.getString(6);
                            dni= ja.getString(7);

                            if (id.equals(etcodigotarje.getText().toString())) {



                                Monto.setText(monto);
                                Estado.setText(estado);
                                user usuario = new user();





                            } else {
                                Toast.makeText(getApplicationContext(), "Codigo incorrecto", Toast.LENGTH_SHORT).show();

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();

                            Toast.makeText(getApplicationContext(), "El codigo no existe en la base de datos", Toast.LENGTH_LONG).show();
                        }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });


                queue.add(stringRequest);


}}

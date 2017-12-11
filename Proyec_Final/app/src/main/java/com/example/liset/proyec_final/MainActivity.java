package com.example.liset.proyec_final;

import android.app.DownloadManager;
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

public class MainActivity extends AppCompatActivity {


    Button btnIngresar;
    EditText etUsuario, etContra;
     String nombres;  TextView nombre;
    JSONArray ja;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etUsuario = (EditText)findViewById(R.id.etUsuario);
        etContra = (EditText)findViewById(R.id.etContra);
        btnIngresar = (Button)findViewById(R.id.btnIngresar);
        nombre = (TextView)findViewById(R.id.etnombre);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ConsultaPass("http://54.218.69.196/ejemplologin/consultarusuario.php?user="+etUsuario.getText().toString());

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
                    ja = new JSONArray(response);
                    String contra = ja.getString(0);
                    nombres = ja.getString(2);
                    if (contra.equals(etContra.getText().toString())) {



                        Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, MostrarActivity.class);
                        //mandar datos a otro main
                        String auxNombre=nombres.toString();
                        intent.putExtra("nombre",auxNombre);
                        startActivity(intent);
                      //   nombre.setText(nombres);
                        user usuario = new user();


                    } else {
                        Toast.makeText(getApplicationContext(), "verifique su contraseña", Toast.LENGTH_SHORT).show();

                    }

                } catch (JSONException e) {
                    e.printStackTrace();

                    Toast.makeText(getApplicationContext(), "El usuario no existe en la base de datos", Toast.LENGTH_LONG).show();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(stringRequest);


    }
    }

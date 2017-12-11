package com.example.liset.proyec_final;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.test.TestSuiteProvider;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.example.liset.proyec_final.R.id.recyclerView;

public class ConsultActivity extends AppCompatActivity {

    private static final String URL_DATA="http://54.218.69.196/ejemplologin/gethistorial.php";
String name, lastname;
    RequestQueue rq;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
TextView nombre, apellido;

    private List<ListItem> listItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);

rq=Volley.newRequestQueue(this);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
nombre=(TextView) findViewById(R.id.textViewnom);
        apellido =(TextView) findViewById(R.id.textViewlast);

        listItems=new ArrayList<>();

        loadRecyclerViewData();
    }

    private void loadRecyclerViewData() {
        /* final ProgressDialog progressDialog= new ProgressDialog(this);
        progressDialog.setMessage("Loading data..");
        progressDialog.show();*/

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_DATA, new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
//progressDialog.dismiss();
                        try {

                           JSONArray ja= new JSONArray(response);

                        // name= ja.getString(0);
                        // lastname= ja.getString(1);

                            nombre.setText("Bienvenido "+name + lastname);


               /* JSONObject  jsonObject = new JSONObject(response);
                         // JSONArray array=jsonObject.getJSONArray("cliente"); */


                       /*  for (int i=0; i < ja.length(); i++){

                              JSONObject o = ja.getJSONObject(i);

                                ListItem item= new ListItem(
                                        ja.getString(0),
                                        ja.getString(1)
                               );
                                listItems.add(item);
                            }
                            adapter = new MyAdapter(listItems, getApplicationContext());
                            recyclerView.setAdapter(adapter);
*/

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                      //  progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(), volleyError.getMessage(), Toast.LENGTH_LONG).show();

                    }
                }
        );
        rq.add(stringRequest);



    }

}

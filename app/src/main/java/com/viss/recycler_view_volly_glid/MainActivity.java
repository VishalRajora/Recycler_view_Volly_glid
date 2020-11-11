package com.viss.recycler_view_volly_glid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String url = "https://simplifiedcoding.net/demos/marvel/";
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    List < ModelClass > myList;
    AdapterClass adapterClass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        myList =  new ArrayList <> ();

        SetRecyclerView ();
        Getdata ();
    }

    private void Getdata() {
        ProgressDialog progressDialog = new ProgressDialog ( MainActivity.this );
        progressDialog.setCanceledOnTouchOutside ( false );
        progressDialog.setMessage ( "Loading" );
        progressDialog.show ();

        RequestQueue requestQueue = Volley.newRequestQueue ( MainActivity.this );

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest ( Request.Method.GET , url , null , new Response.Listener < JSONArray > () {
            @Override
            public void onResponse(JSONArray response) {
                progressDialog.dismiss ();

                for (int i = 0; i < response.length (); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject ( i );

                        String name = jsonObject.getString ( "name" );
                        String realname = jsonObject.getString ( "realname" );
                        String team = jsonObject.getString ( "team" );
                        String createdby = jsonObject.getString ( "createdby" );
                        String publisher = jsonObject.getString ( "publisher" );
                        String imageurl = jsonObject.getString ( "imageurl" );
                        int firstappearance = jsonObject.getInt ( "firstappearance" );
                        ModelClass modelClass = new ModelClass ( name , realname , team , publisher , createdby , imageurl , firstappearance );
                        myList.add ( modelClass );
                    } catch (JSONException e) {
                        progressDialog.dismiss ();
                        e.printStackTrace ();
                    }

                }

                adapterClass =  new AdapterClass ( myList , MainActivity.this );
                recyclerView.setAdapter ( adapterClass );
                adapterClass.notifyDataSetChanged ();

            }
        } , new Response.ErrorListener () {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss ();
                Toast.makeText ( MainActivity.this , "Errror" , Toast.LENGTH_SHORT ).show ();

            }
        } );

        requestQueue.add ( jsonArrayRequest );
    }

    private void SetRecyclerView() {

        recyclerView = findViewById ( R.id.recycler_View );
        recyclerView.hasFixedSize ();
        layoutManager = new LinearLayoutManager ( MainActivity.this , RecyclerView.VERTICAL , false );
        recyclerView.setLayoutManager ( layoutManager );


    }
}
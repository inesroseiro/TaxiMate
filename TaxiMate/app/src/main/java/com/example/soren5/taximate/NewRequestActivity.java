package com.example.soren5.taximate;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class NewRequestActivity extends AppCompatActivity {
    Mycanvas mycanvas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mycanvas mycanvas = new Mycanvas(getApplicationContext());
        mycanvas.setBackgroundColor(Color.rgb(255,255,102));
        setContentView(R.layout.activity_main);
        ImageButton imageButton = (ImageButton)findViewById(R.id.imageButton4);
        Intent intent = getIntent();
        final String userID = intent.getStringExtra("id");
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                criarPedido(view, userID);
            }
        });
    }

    protected void criarPedido(View view, String userID){
        final String origem = ((EditText)findViewById(R.id.editText)).getText().toString();
        String destino = ((EditText)findViewById(R.id.editText2)).getText().toString();
        String cidade = ((EditText)findViewById(R.id.editText3)).getText().toString();
        String data = ((EditText)findViewById(R.id.editText4)).getText().toString();
        String hora = ((EditText)findViewById(R.id.editText5)).getText().toString();
        String nome = getIntent().getStringExtra("name");

        Log.v("myTag", nome);
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference();
        String key = myRef.push().getKey();
        if (key != null){
            Log.v("myTag", key);
            DatabaseReference ref1 = myRef.child(userID);
            DatabaseReference ref2 = ref1.child("pedidos");
            DatabaseReference ref3 = ref2.child(key);
            ref3.setValue(new Pedido(key, userID, nome, origem, destino, cidade, data, hora));
        }
        else {
            Log.v("myTag", myRef.getKey());
            Log.v("myTag", myRef.push().getKey());
        }
        final Intent listIntent = new Intent(NewRequestActivity.this, FriendRequestListActivity.class);
        listIntent.putExtra("id", getIntent().getStringExtra("id"));
        listIntent.putExtra("name", getIntent().getStringExtra("name"));
        startActivity(listIntent);
        finish();
    }
}

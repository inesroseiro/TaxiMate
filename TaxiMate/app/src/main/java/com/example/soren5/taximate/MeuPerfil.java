package com.example.soren5.taximate;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.login.LoginManager;
import com.facebook.login.widget.ProfilePictureView;

public class MeuPerfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meu_perfil);

        Intent intent = getIntent();
        final String userID = intent.getStringExtra("id");
        final String name = intent.getStringExtra("name");
        final String surname = intent.getStringExtra("lastname");
        final String birthday = intent.getStringExtra("birthday");

        TextView nameView = (TextView) findViewById(R.id.name_surname);
        TextView birthdayView = (TextView) findViewById(R.id.text_date);


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.NavBot);
        //BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.feed_pedidos:
                                Intent intent = new Intent(MeuPerfil.this, ListActivity.class);
                                intent.putExtra("id", userID);

                                intent.putExtra("name", name);

                                intent.putExtra("lastname", surname);
                                intent.putExtra("birthday", birthday);
                                startActivity(intent);
                                finish();
                                break;
                            case R.id.logout:
                                Intent intent2 = new Intent(MeuPerfil.this, LogoutActivity.class);
                                intent2.putExtra("id", userID);

                                    intent2.putExtra("name", name);

                                    intent2.putExtra("lastname", surname);
                                    intent2.putExtra("birthday", birthday);

                                startActivity(intent2);

                                finish();
                                break;
                        }

                        return false;
                    }
                });

        nameView.setText("Nome: " + name + " " + surname);

        birthdayView.setText("Data de nascimento: " + birthday);

        ProfilePictureView profilePicture = (ProfilePictureView) findViewById(R.id.profilePicture);
        profilePicture.setProfileId(userID);


    }


}


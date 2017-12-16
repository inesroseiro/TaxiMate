package com.example.soren5.taximate;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.login.LoginManager;
import com.facebook.login.widget.ProfilePictureView;

public class FacebookProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook_profile);
        Intent intent = getIntent();
        String userID = intent.getStringExtra("id");
        String nome = intent.getStringExtra("nome");
        String apelido = intent.getStringExtra("apelido");

        TextView nameView = (TextView) findViewById(R.id.nome_apelido);

        nameView.setText(" " + nome + " " + apelido);

        ProfilePictureView profilePicture = (ProfilePictureView) findViewById(R.id.fotoPerfil);
        profilePicture.setProfileId(userID);

        Button logout = (Button)findViewById(R.id.logout_button);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });
    }

    private void logout() {
        LoginManager.getInstance().logOut();
        Intent login = new Intent(FacebookProfile.this, MainActivity.class);
        startActivity(login);
        finish();
    }

}


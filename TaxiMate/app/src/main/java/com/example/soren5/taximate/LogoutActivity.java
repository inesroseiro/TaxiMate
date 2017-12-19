package com.example.soren5.taximate;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;

import org.json.JSONException;
import org.json.JSONObject;

public class LogoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);

        Button logout = (Button)findViewById(R.id.logout_button);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });




        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.NavBot);
        //BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);


        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.meu_perfil:
                                Intent intent = new Intent(LogoutActivity.this, MeuPerfil.class);
                                startActivity(intent);
                                finish();
                                break;


                            case R.id.feed_pedidos:
                                Intent intent2 = new Intent(LogoutActivity.this, ListActivity.class);
                                startActivity(intent2);
                                finish();
                                break;
                        }

                        return false;
                    }
                });


    }

    private void logout() {
        LoginManager.getInstance().logOut();
        Intent login = new Intent(LogoutActivity.this, MainActivity.class);
        startActivity(login);
        finish();
    }



    private void get_profile(AccessToken accessToken){
        GraphRequest request = GraphRequest.newMeRequest(
                accessToken, new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        Intent profileIntent = new Intent(LogoutActivity.this, MeuPerfil.class);
                        try {
                            String userID = object.getString("id");
                            profileIntent.putExtra("id", userID);
                            String firstname = "";
                            String lastname = "";
                            String email = "";
                            String birthday = "";
                            String gender = "";

                            if (object.has("first_name")) {
                                firstname = object.getString("first_name");
                                profileIntent.putExtra("name", firstname);
                            }
                            if (object.has("last_name")) {
                                lastname = object.getString("last_name");
                                profileIntent.putExtra("lastname", lastname);
                            }

                            if (object.has("birthday")) {
                                birthday = object.getString("birthday");
                                profileIntent.putExtra("birthday", birthday);
                            }

                            startActivity(profileIntent);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id, first_name, last_name, birthday");
        request.setParameters(parameters);
        request.executeAsync();

    }

}

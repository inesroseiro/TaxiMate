package com.example.soren5.taximate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_important);

        callbackManager = CallbackManager.Factory.create();

        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions("email", "user_birthday", "user_posts");


        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                AccessToken accessToken = loginResult.getAccessToken();
                Toast.makeText(getApplicationContext(), "Logging in...", Toast.LENGTH_SHORT).show();
                GraphRequest graphRequest = GraphRequest.newGraphPathRequest(accessToken,
                        "me?fields=friends{first_name,last_name}",
                        new GraphRequest.Callback() {
                            @Override
                            public void onCompleted(GraphResponse response) {
                                //Log.d("myTag", response.toString());
                            }
                        });
                graphRequest.executeAsync();

                get_profile(accessToken);
            }

            @Override
            public void onCancel() {
            }

            @Override
            public void onError(FacebookException error) {
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent
            data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
    private void get_profile(final AccessToken accessToken){
        final Intent listIntent = new Intent(MainActivity.this, NewRequestActivity.class);
        GraphRequest request = GraphRequest.newMeRequest(accessToken, new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        String userID = null;
                        String name = null;
                        Log.v("myTage", accessToken.toString());
                        try {
                            userID = object.getString("id");
                            name = object.getString("name");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Log.v("myTag", name);
                        listIntent.putExtra("id", userID);
                        listIntent.putExtra("name", name);
                        startActivity(listIntent);
                        finish();
                    }
                });
        request.executeAsync();
        /*
        GraphRequest request = GraphRequest.newMeRequest(
                accessToken, new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        Intent profileIntent = new Intent(MainActivity.this, FacebookProfile.class);
                        try {
                            String userID = object.getString("id");
                            profileIntent.putExtra("id", userID);
                            String firstname = "";
                            String lastname = "";

                            if (object.has("first_name")) {
                                firstname = object.getString("first_name");
                                profileIntent.putExtra("nome", firstname);
                            }
                            if (object.has("last_name")) {
                                lastname = object.getString("last_name");
                                profileIntent.putExtra("apelido", lastname);
                            }

                            startActivity(profileIntent);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id, first_name, last_name");
        request.setParameters(parameters);
        request.executeAsync();
        */
    }
}

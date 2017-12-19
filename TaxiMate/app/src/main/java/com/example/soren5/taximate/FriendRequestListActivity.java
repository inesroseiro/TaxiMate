package com.example.soren5.taximate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.widget.ProfilePictureView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FriendRequestListActivity extends AppCompatActivity {

    ListView listView;
    List list = new ArrayList<>();
    BaseAdapter adapter;
    DatabaseReference databaseReference;
    ArrayList<Pedido> pedidoArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_request_list);
        Intent intent = getIntent();
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        final String userID = intent.getStringExtra("id");
        GraphRequest graphRequest = GraphRequest.newGraphPathRequest(accessToken, "me?fields=friends{first_name,last_name}", new GraphRequest.Callback() {
            @Override
            public void onCompleted(GraphResponse response) {
                JSONObject object = response.getJSONObject();
                Log.d("myTag",object.toString() );
                try {
                    JSONArray friendArray = ((JSONObject)object.get("friends")).getJSONArray("data");
                    for(int i = 0; i < friendArray.length(); i++){
                        Log.v("myTag", friendArray.get(i).toString());
                    }
                    listView = (ListView) findViewById(R.id.list_view);
                    adapter = new CustomAdapter();
                    listView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        graphRequest.executeAsync();
    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return pedidoArrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @SuppressLint("SetTextI18n")
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            view = getLayoutInflater().inflate(R.layout.pedido_layout, null);
            ProfilePictureView imageView = (ProfilePictureView) view.findViewById(R.id.foto_view);
            TextView nomeView = (TextView)view.findViewById(R.id.nome_text_view);
            TextView deView = (TextView)view.findViewById(R.id.de_text_view);
            TextView paraView = (TextView)view.findViewById(R.id.para_text_view);
            TextView dataLocalView = (TextView)view.findViewById(R.id.data_local_text_view);

            imageView.setProfileId(pedidoArrayList.get(i).getUserID());
            nomeView.setText(pedidoArrayList.get(i).getNome());
            deView.setText(pedidoArrayList.get(i).getDe());
            paraView.setText(pedidoArrayList.get(i).getPara());
            dataLocalView.setText(pedidoArrayList.get(i).getData() + " " + pedidoArrayList.get(i).getHora() + " " + pedidoArrayList.get(i).getCidade());
            Log.v("myTag", "Hello i am view #" + i);
            return view;
        }
    }
}

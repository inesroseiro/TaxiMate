package com.example.soren5.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    int[] IMAGES = {R.drawable.catarina, R.drawable.cunha, R.drawable.ines, R.drawable.linhac, R.drawable.pedrocas, R.drawable.ze};
    String[] NOME = {"Catarina", "Jose", "Ines", "Rui", "Pedro", "Jose"};
    String[] DE = {"Polo 2", "Polo 1", "Moelas", "Escola de Hotelaria", "Palacio do Bairro", "Praca da Republica"};
    String[] PARA = {"Casa do Povo", "Forum", "Alma Shopping", "Parque do urso", "Portugal dos pequenitos", "Shangai"};
    String[] DATA_E_LOCAL = {"HOJE AS 21:00 - Coimbra","HOJE AS 12:23 - Coimbra","HOJE AS 10:04 - Coimbra","HOJE AS 21:07 - Coimbra","HOJE AS 22:03 - Coimbra","HOJE AS 21:34 - Shangai"};
    ListView listView;
    List list = new ArrayList<>();
    BaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list_view);

        adapter = new CustomAdapter();
        listView.setAdapter(adapter);
    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.pedido_layout, null);
            ImageView imageView = (ImageView)view.findViewById(R.id.foto_view);
            TextView nomeView = (TextView)view.findViewById(R.id.nome_text_view);
            TextView deView = (TextView)view.findViewById(R.id.de_text_view);
            TextView paraView = (TextView)view.findViewById(R.id.para_text_view);
            TextView dataLocalView = (TextView)view.findViewById(R.id.data_local_text_view);

            imageView.setImageResource(IMAGES[i]);
            nomeView.setText(NOME[i]);
            deView.setText(DE[i]);
            paraView.setText(PARA[i]);
            dataLocalView.setText(DATA_E_LOCAL[i]);
            return view;
        }
    }
}
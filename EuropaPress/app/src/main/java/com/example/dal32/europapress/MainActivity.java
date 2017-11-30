package com.example.dal32.europapress;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.grid);

        new miTarea().execute("http://www.europapress.es/rss/rss.aspx");
        //El metodo execute necesita la clase doInBackground para funcionar.
    }

    public class miTarea extends AsyncTask<String, Float, Integer> {
        List<Noticia> noticias;

        @Override
        protected Integer doInBackground(String... params) {
            RssParserSax sax = new RssParserSax(params[0]);

            noticias = sax.parse();

            publishProgress(250f);

            return null;
        }

        @Override
        protected void onProgressUpdate(Float... values) {
            AdaptadorNoticias adaptador = new AdaptadorNoticias(MainActivity.this, noticias);
            listview.setAdapter(adaptador);
        }
    }
}

package com.example.dal32.comedor;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dal32.comedor.AdaptadorComedor;
import com.example.dal32.comedor.Comedor;
import com.example.dal32.comedor.R;
import com.example.dal32.comedor.RssParserSax;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.grid);

        new miTarea().execute("http://www.informaticasalesianoszgz.org.es/menus.xml");
        //El metodo execute necesita la clase doInBackground para funcionar.
    }

    public class miTarea extends AsyncTask<String, Float, Integer> {
        List<Comedor> comida;

        @Override
        protected Integer doInBackground(String... params) {
            RssParserSax sax = new RssParserSax(params[0]);

            comida = sax.parse();

            publishProgress(250f);

            return null;
        }

        @Override
        protected void onProgressUpdate(Float... values) {
            AdaptadorComedor adaptador = new AdaptadorComedor(MainActivity.this, comida);
            listview.setAdapter(adaptador);
        }
    }
}

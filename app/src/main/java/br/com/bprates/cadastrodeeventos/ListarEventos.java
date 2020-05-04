package br.com.bprates.cadastrodeeventos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import br.com.bprates.cadastroeventos.R;

public class ListarEventos extends AppCompatActivity {

    private ListView listaDeEventos;
    private List<Evento> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_eventos);
        Bundle extra = getIntent().getExtras();

        listaDeEventos = findViewById(R.id.lv_eventos);
        Log.d("teste", "aqui!");

        if (extra != null) {
            list = (List<Evento>) getIntent().getSerializableExtra("eventosCadastrados");

            ArrayAdapter<Evento> adaptador = new ArrayAdapter<Evento>(
                    getApplicationContext(),
                    android.R.layout.simple_list_item_1,
                    android.R.id.text1,
                    list);

            listaDeEventos.setAdapter(adaptador);

        }
    }
}

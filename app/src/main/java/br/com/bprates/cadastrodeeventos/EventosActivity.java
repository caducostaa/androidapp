package br.com.bprates.cadastrodeeventos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.bprates.cadastroeventos.R;

public class EventosActivity extends AppCompatActivity {

    private TextView tvNome;
    private TextView tvEmail;
    private TextView tvLocal;
    private TextView tvQtdPessoas;
    private ArrayList<Evento> eventosSalvos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);
        Bundle extra = getIntent().getExtras();

        tvNome = findViewById(R.id.tv_nome);
        tvEmail = findViewById(R.id.tv_email);
        tvLocal = findViewById(R.id.tv_local);
        tvQtdPessoas = findViewById(R.id.tv_qtdPessoas);



        if (extra != null) {
            Evento evento = (Evento) getIntent().getSerializableExtra("evento");
            eventosSalvos = (ArrayList<Evento>) getIntent().getSerializableExtra("eventosSalvos");
            tvNome.setText(evento.getNome());
            tvEmail.setText(evento.getEmail());
            tvLocal.setText(evento.getLocal());
            tvQtdPessoas.setText(evento.getQtdPessoas());
        }
    }

    public void listarEventos(View view) {
        Intent listarIntent = new Intent(this, ListarEventos.class);
        listarIntent.putExtra("eventosCadastrados", eventosSalvos);
        startActivity(listarIntent);
    }
}

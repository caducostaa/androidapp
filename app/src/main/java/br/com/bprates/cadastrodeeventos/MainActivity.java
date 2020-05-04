package br.com.bprates.cadastrodeeventos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.bprates.cadastroeventos.R;

public class MainActivity extends AppCompatActivity {

    private SeekBar sb;
    private TextView tv_seekbar;
    private AlertDialog.Builder alertaDialog;
    private EditText nome;
    private EditText email;
    private EditText local;
    private EditText qtdPessoas;
    private ArrayList<Evento> eventosSalvos = new ArrayList<Evento>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void salvarEvento(View view) {
        alertaDialog = new AlertDialog.Builder( this );
        alertaDialog.setTitle("Salvar Evento");
        alertaDialog.setMessage("Você realmente deseja salvar esse evento?");
        alertaDialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                nome = findViewById(R.id.et_nome);
                email = findViewById(R.id.et_email);


                Evento novoEvento = new Evento(
                        nome.getText().toString(),
                        email.getText().toString(),
                        local.getText().toString(),
                        qtdPessoas.getText().toString());

                eventosSalvos.add(novoEvento);
                Intent eventoIntent = new Intent(MainActivity.this, EventosActivity.class);
                eventoIntent.putExtra("evento", novoEvento);
                eventoIntent.putExtra("eventosSalvos", eventosSalvos);
                startActivity(eventoIntent);
            }
        });
        alertaDialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"Evento não salvo", Toast.LENGTH_SHORT).show();
            }
        });

        alertaDialog.create();
        alertaDialog.show();
    }
}

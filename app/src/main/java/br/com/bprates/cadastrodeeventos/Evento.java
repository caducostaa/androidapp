package br.com.bprates.cadastrodeeventos;

import android.text.Editable;

import java.io.Serializable;
import java.util.ArrayList;

public class Evento implements Serializable {
    private String nome;
    private String email;
    private String local;
    private String qtdPessoas;


    public Evento(String nome, String email, String local, String qtdPessoas) {
        this.nome = nome;
        this.email = email;
        this.local = local;
        this.qtdPessoas = qtdPessoas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getQtdPessoas() {
        return qtdPessoas;
    }

    public void setQtdPessoas(String qtdPessoas) {
        this.qtdPessoas = qtdPessoas;
    }


    @Override
    public String toString() {
        return "Nome: " + nome + "\nEmail: " + email;
    }
}

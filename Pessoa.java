package model;

public abstract class Pessoa {
    protected static int contador = 1;

    protected int id;
    protected String nome;

    public Pessoa(String nome) {
        this.id = contador++;
        this.nome = nome;
    }

    public abstract double calcularMediaFinal();

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}

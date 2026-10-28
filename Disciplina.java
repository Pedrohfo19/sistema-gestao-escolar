package model;

public class Disciplina {

    private String nome;
    private int cargaHoraria;

    public Disciplina(String nome) {
        this.nome = nome;
        this.cargaHoraria = 60; // padrão
    }

    public Disciplina(String nome, int cargaHoraria) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }

    public String getNome() {
        return nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    @Override
    public String toString() {
        return nome + " (" + cargaHoraria + "h)";
    }
}

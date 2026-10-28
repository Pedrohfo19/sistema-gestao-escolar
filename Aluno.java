package model;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa {

    private String matrícula;
    private double desconto;

    private List<Double> notas = new ArrayList<>();

    public Aluno (String nome, String matrícula) {
        super(nome);
        this.matrícula = matrícula;
    }
    public void adicionarNota(double nota) {
        notas.add(nota);
    }

    public void adicionarNota(double [] notas) {
        for (double n : notas) {
            this.notas.add(n);
        }
    }
    public double getMedia() {
        if (notas.isEmpty()) return 0;

        double soma = 0;
        for (double n : notas) soma += n;
        return soma /  notas.size();
    }
    public void aplicarDesconto(double valor) {
        final double Desconto_Máximo = 0.5;

        if (valor > Desconto_Máximo) {
            this.desconto = Desconto_Máximo;
        }
        else {
            this.desconto = valor;
        }
    }
    @Override
    public double calcularMediaFinal() {
        return getMedia();
    }
    @Override
    public String toString() {
        return "Aluno: " + nome + " | Matrícula: " + matrícula;
    }
}

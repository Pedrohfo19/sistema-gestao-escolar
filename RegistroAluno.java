package model;

import java.util.ArrayList;
import java.util.List;

public class RegistroAluno {

    private Disciplina disciplina;
    private List<Double> notas = new ArrayList<>();
    private int faltas;

    public RegistroAluno(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public void adicionarNota(double nota) {
        notas.add(nota);
    }

    public void adicionarNota(double[] notas) {
        for (double n : notas) {
            this.notas.add(n);
        }
    }

    public void registrarFalta() {
        faltas++;
    }

    public double media() {
        if (notas.isEmpty()) return 0;

        double soma = 0;
        for (double n : notas) {
            soma += n;
        }
        return soma / notas.size();
    }

    public String status() {
        return media() >= 7 ? "Aprovado" : "Reprovado";
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public int getFaltas() {
        return faltas;
    }

    public List<Double> getNotas() {
        return notas;
    }
}


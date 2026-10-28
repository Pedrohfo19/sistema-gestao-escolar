package model;

import enums.Turno;
import exceptions.TurmaLotadaException;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private static int limitePadrao = 3;

    private String nome;
    private Turno turno;
    private Disciplina disciplina;
    private Professor professor;

    private List<Aluno> alunos = new ArrayList<>();

    public Turma(String nome, Turno turno, Disciplina disciplina, Professor professor) {
        this.nome = nome;
        this.turno = turno;
        this.disciplina = disciplina;
        this.professor = professor;
    }

    public void matricularAluno(Aluno a) throws TurmaLotadaException {
        if (alunos.size() >= limitePadrao) {
            throw new TurmaLotadaException("Turma lotada!");
        }
        alunos.add(a);
    }

    public void removerAluno(Aluno a) {
        alunos.remove(a);
    }

    public double mediaTurma() {
        if (alunos.isEmpty()) return 0;

        double soma = 0;
        for (Aluno a : alunos) {
            soma += a.getMedia();
        }
        return soma / alunos.size();
    }
    public String getNome() {
        return nome;
    }
    public Turno getTurno() {
        return turno;
    }
    public List<Aluno> getAlunos() {
        return alunos;
    }
    public Professor getProfessor() {
        return professor;
    }
}

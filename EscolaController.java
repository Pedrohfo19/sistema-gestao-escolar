package controller;

import exceptions.NotaInvalidaException;
import model.Aluno;
import model.Turma;

import java.util.ArrayList;
import java.util.List;

public class EscolaController {

    private List <Turma> turmas = new ArrayList<>();
    private List<Aluno> alunos = new ArrayList<>();

    public void cadastrarAluno(Aluno a) {
        alunos.add(a);
    }

    public void cadastrarTurma(Turma t) {
        turmas.add(t);
    }

    public Aluno buscarAluno(int id) {
        for (Aluno a : alunos) {
            if (a.getId() == id) return a;
        }
        return null;
    }

    public Turma buscarTurma(String nome) {
        for (Turma t : turmas) {
            if (t.getNome().equalsIgnoreCase(nome)) return t;
        }
        return null;
    }

    public void matricular(int idAluno, String nomeTurma) throws Exception {
        Aluno a = buscarAluno(idAluno);
        Turma t = buscarTurma(nomeTurma);

        if (a == null || t == null) return;

        t.matricularAluno(a);
    }

    public void lancarNota(int idAluno, double nota) throws NotaInvalidaException {
        if (nota < 0 || nota > 10) {
            throw new NotaInvalidaException("Nota inválida!");
        }

        Aluno a = buscarAluno(idAluno);
        if (a != null) {
            a.adicionarNota(nota);
        }
    }
    public void lancarNota(int idAluno, double[] notas) throws NotaInvalidaException {
        for (double n : notas) {
            if (n < 0 || n > 10) {
                throw new NotaInvalidaException("Não foi possível lançar as notas!");
            }
        }

        Aluno a = buscarAluno(idAluno);
        if (a != null) {
            a.adicionarNota(notas);
        }
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }
}

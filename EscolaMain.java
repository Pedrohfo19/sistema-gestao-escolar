package view;

import controller.EscolaController;
import enums.Turno;
import exceptions.NotaInvalidaException;
import exceptions.TurmaLotadaException;
import model.Aluno;
import model.Disciplina;
import model.Professor;
import model.Turma;

import javax.swing.*;

public class EscolaMain {

    public static void main(String[] args) {

        EscolaController controller = new EscolaController();

        while (true) {

            String opcao = JOptionPane.showInputDialog(
                    " Sistema Escolar \n" +
                            "1 - Cadastrar Aluno\n" +
                            "2 - Cadastrar Turma\n" +
                            "3 - Matricular Aluno\n" +
                            "4 - Lançar Nota\n" +
                            "5 - Ver Média Aluno\n" +
                            "0 - Sair"
            );

            if (opcao == null) break;

            try {
                switch (opcao) {

                    case "1": {
                        String nome = JOptionPane.showInputDialog("Nome:");
                        String matricula = JOptionPane.showInputDialog("Matrícula:");

                        controller.cadastrarAluno(new Aluno(nome, matricula));
                        break;
                    }

                    case "2": {
                        String nome = JOptionPane.showInputDialog("Nome turma:");
                        String turno = JOptionPane.showInputDialog("Turno (MANHA/TARDE/NOITE)");
                        String prof = JOptionPane.showInputDialog("Nome professor:");
                        double salario = Double.parseDouble(JOptionPane.showInputDialog("Salário:"));
                        String disc = JOptionPane.showInputDialog("Disciplina:");

                        Professor p = new Professor(prof, salario);
                        Disciplina d = new Disciplina(disc);

                        Turma t = new Turma(nome, Turno.valueOf(turno.toUpperCase()), d, p);

                        controller.cadastrarTurma(t);
                        break;
                    }

                    case "3": {
                        int id = Integer.parseInt(JOptionPane.showInputDialog("ID aluno:"));
                        String turma = JOptionPane.showInputDialog("Nome turma:");

                        controller.matricular(id, turma);
                        break;
                    }

                    case "4": {
                        int id = Integer.parseInt(JOptionPane.showInputDialog("ID aluno:"));
                        double nota = Double.parseDouble(JOptionPane.showInputDialog("Nota:"));

                        controller.lancarNota(id, nota);
                        break;
                    }

                    case "5": {
                        int id = Integer.parseInt(JOptionPane.showInputDialog("ID aluno:"));
                        Aluno a = controller.buscarAluno(id);

                        if (a != null) {
                            JOptionPane.showMessageDialog(null,
                                    a + "Média: " + a.getMedia());
                        }

                        break;
                    }

                    case "0":
                        System.exit(0);
                }

            } catch (NotaInvalidaException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (TurmaLotadaException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        }
    }
}

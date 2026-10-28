package model;

public class Professor extends Pessoa {

    private double salario;

    public Professor(String nome, double salario) {
        super (nome);
        this.salario = salario;
    }

    @Override
    public double calcularMediaFinal() {
        return 0;
    }
    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return "Professor: " + nome;
    }
}

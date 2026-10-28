package model;

public class FinanceiroAluno {

    private double mensalidade = 500.0;

    public static final double MAX_DESCONTO = 0.5; // 50%

    private double descontoAplicado;

    public void aplicarDesconto(double percentual) {

        if (percentual > MAX_DESCONTO) {
            descontoAplicado = MAX_DESCONTO;
        } else {
            descontoAplicado = percentual;
        }
    }

    public double valorFinal() {
        return mensalidade - (mensalidade * descontoAplicado);
    }

    public double getMensalidade() {
        return mensalidade;
    }

    public double getDescontoAplicado() {
        return descontoAplicado;
    }
}
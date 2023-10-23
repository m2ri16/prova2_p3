public class ClienteEspecial extends Cliente {
    private int pontos;
    private double saldoDeCompras;


    public ClienteEspecial(String nome, String idade, String cpf, String endereco, boolean bomCliente,
            Item[] carrinhoDeCompras, int pontos, double saldoDeCompras) {
        super(nome, idade, cpf, endereco, bomCliente, carrinhoDeCompras);
        this.pontos = 0;
        this.saldoDeCompras = 0.0;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public double getSaldoDeCompras() {
        return saldoDeCompras;
    }

    public void setSaldoDeCompras(double saldoDeCompras) {
        this.saldoDeCompras = saldoDeCompras;
    }

    @Override
    public double finalizarCompra() {
        double totalCompra = super.finalizarCompra();
        double desconto = 0.05 * totalCompra;
        pontos += 5;
        saldoDeCompras += desconto;
        if (saldoDeCompras >= 100) {
            int pontosExtras = (int) (saldoDeCompras / 100);
            pontos += pontosExtras;
            saldoDeCompras %= 100;
        }
        return totalCompra - desconto;
    }
}

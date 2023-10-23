public class Funcionario extends ClienteEspecial{
    private String setor;
    private int id;
    private double salario;

   
    public Funcionario(String nome, String idade, String cpf, String endereco, boolean bomCliente,
            Item[] carrinhoDeCompras, int pontos, double saldoDeCompras, String setor, int id, double salario) {
        super(nome, idade, cpf, endereco, bomCliente, carrinhoDeCompras, pontos, saldoDeCompras);
        this.setor = setor;
        this.id = id;
        this.salario = salario;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void renovarEstoque(Item item, int quantidade) {
        int estoqueAtual = item.getQuantidadeEmEstoque();
        item.setQuantidadeEmEstoque(estoqueAtual + quantidade);
    }

    public void bloquearItem(Item item, boolean bloquear) {
        item.setDisponibilidade(!bloquear);
    }
}

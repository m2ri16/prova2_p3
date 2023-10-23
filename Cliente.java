public class Cliente {
    private String nome;
    private String idade;
    private String cpf;
    private String endereco;
    private boolean bomCliente;
    private Item[] carrinhoDeCompras;
    private int itensCarrinho;

    public Cliente(String nome, String idade, String cpf, String endereco, boolean bomCliente,
            Item[] carrinhoDeCompras) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.endereco = endereco;
        this.bomCliente = false;
        this.carrinhoDeCompras = new Item[100];
        this.itensCarrinho = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public boolean isBomCliente() {
        return bomCliente;
    }

    public void setBomCliente(boolean bomCliente) {
        this.bomCliente = bomCliente;
    }

    public Item[] getCarrinhoDeCompras() {
        return carrinhoDeCompras;
    }

    public void setCarrinhoDeCompras(Item[] carrinhoDeCompras) {
        this.carrinhoDeCompras = carrinhoDeCompras;
    }

    public int getItensCarrinho() {
        return itensCarrinho;
    }

    public void setItensCarrinho(int itensCarrinho) {
        this.itensCarrinho = itensCarrinho;
    }

    public void adicionar(Item item) {
        if (itensCarrinho < 100) {
            carrinhoDeCompras[itensCarrinho] = item;
            itensCarrinho++;
        }
    }

    public void cancelar(int codigo) {
        for (int i = 0; i <= itensCarrinho; i++) {
            if (carrinhoDeCompras[i] != null && carrinhoDeCompras[i].getCodigo() == codigo) {
                carrinhoDeCompras[i] = null;
                itensCarrinho--;
                break;
            }
        }
    }

    public double finalizarCompra() {
        double totalCompra = 0;
        for (int i = 0; i < itensCarrinho; i++) {
            if (carrinhoDeCompras[i] != null) {
                totalCompra += carrinhoDeCompras[i].getValor();
                carrinhoDeCompras[i].decrementarEstoque();
            }
        }
        return totalCompra;
    }    
}

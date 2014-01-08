package tipos;

public class ProdutoTAD {
	private String codigo;
        //private String nome;
	private String descricao;
	private int qtdEstoq;
	private String categoria;
        private double precoVenda;

    public ProdutoTAD(String codigo, String descricao, int qtdEstoq, String categoria, double precoVenda) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.qtdEstoq = qtdEstoq;
        this.categoria = categoria;
        this.precoVenda = precoVenda;
        
    }

    public ProdutoTAD(String codigo, int qtdEstoq, double precoVenda) {
        this.codigo = codigo;
        this.qtdEstoq = qtdEstoq;
        this.precoVenda = precoVenda;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtdEstoq() {
        return qtdEstoq;
    }

    public void setQtdEstoq(int qtdEstoq) {
        this.qtdEstoq = qtdEstoq;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }
     
     
        
}

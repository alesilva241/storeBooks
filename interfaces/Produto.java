package interfaces;

import tipos.ProdutoLivro;
import tipos.ProdutoTAD;

public interface Produto {
	
        public boolean verificaListaEhVazia();
	public void cadastrarProduto(ProdutoLivro produto);
	public void editarProduto(String codigo);
        public boolean buscarProduto(String codigo);
        public void listarProdutos();
        public double pegarPreco(String codigoProduto);

}

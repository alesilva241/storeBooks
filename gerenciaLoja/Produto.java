package gerenciaLoja;

import interfaces.Mercadoria;

import java.util.ArrayList;

import tipos.ProdutoTAD;

public class Produto implements Mercadoria{
	
	private ArrayList<ProdutoTAD> listProdutos;

	public ArrayList<ProdutoTAD> getListProdutos() {
		return listProdutos;
	}
	public void setListProdutos(ArrayList<ProdutoTAD> listProdutos) {
		this.listProdutos = listProdutos;
	}
	@Override
	public void cadastrarProduto() {
		
	}
	public void editarProduto(){
		
	}
}

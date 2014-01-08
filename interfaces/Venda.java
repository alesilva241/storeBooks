/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

/**
 *
 * @author alexandra
 */
public interface Venda {
    
    public void novaCompra();
    public void listarCompras();
    public boolean verificaListaEhVazia();
    public int verificaDisponibilidadeEstoque(String codigo);
    public void removeProduto(String codigo, int qtdComprada);
    public void alteraStatus(String codVenda);
    public int escolhaEndereco(int indexComprador);
    public boolean buscarProduto(String codigo);
    public boolean buscaPessoaCPF(String cpf);
    public int localizarPessoa(String cpf);
    public double pegarPreco(String codigoProduto);
    
}

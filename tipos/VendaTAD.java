/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tipos;

import java.util.ArrayList;

/**
 *
 * @author alexandra
 */
public class VendaTAD {
    
    private String codigoVenda;
    private PessoaTAD comprador;
    private EnderecoTAD enderecoEscolhido;
    private ArrayList<ProdutoTAD> listaCompras;
    private String status;
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(String codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    public PessoaTAD getComprador() {
        return comprador;
    }

    public void setComprador(PessoaTAD comprador) {
        this.comprador = comprador;
    }

    public EnderecoTAD getEnderecoEscolhido() {
        return enderecoEscolhido;
    }

    public void setEnderecoEscolhido(EnderecoTAD enderecoEscolhido) {
        this.enderecoEscolhido = enderecoEscolhido;
    }

    public ArrayList<ProdutoTAD> getListaCompras() {
        return listaCompras;
    }

    public void setListaCompras(ArrayList<ProdutoTAD> listaCompras) {
        this.listaCompras = listaCompras;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public VendaTAD(String codigoVenda, PessoaTAD comprador, EnderecoTAD enderecoEscolhido, ArrayList<ProdutoTAD> listaCompras, String status, String data) {
        this.codigoVenda = codigoVenda;
        this.comprador = comprador;
        this.enderecoEscolhido = enderecoEscolhido;
        this.listaCompras = listaCompras;
        this.status = status;
        this.data = data;
    }
}

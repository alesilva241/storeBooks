/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipos;

/**
 *
 * @author alexandra
 */
public class ProdutoLivro extends ProdutoTAD {

    private String titulo;
    private String autor;

    public ProdutoLivro(String codigo, String descricao, int qtdEstoq, String categoria, double precoVenda, String titulo, String autor) {
        super(codigo, descricao, qtdEstoq, categoria, precoVenda);
        this.autor = autor;
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

}

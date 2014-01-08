package gerenciaLoja;

import interfaces.Produto;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import tipos.ProdutoLivro;

public class Estoque implements Produto {

    private ArrayList<ProdutoLivro> listProdutos = new ArrayList<>();

    public ArrayList<ProdutoLivro> getListProdutos() {
        return listProdutos;
    }

    public void setListProdutos(ArrayList<ProdutoLivro> listProdutos) {
        this.listProdutos = listProdutos;
    }

    @Override
    public void cadastrarProduto(ProdutoLivro produto) {
        listProdutos.add(produto);

    }

    @Override
    public void editarProduto(String codigo) {
        boolean retorno = false;
        String codigoNovo, descricaoNova, categoriaNova;
        int qtdEstoqNova;
        double precoVendaNovo;

        int indexLista = 0, editar;
        for (int i = 0; i < listProdutos.size(); i++) {
            if (listProdutos.get(i).getCodigo().equals(codigo)) {
                retorno = true;
                indexLista = i;
            }
        }
        if (retorno) {
            System.out.println("\n Preparando para editar...");
            try{
            editar = Integer.parseInt(JOptionPane.showInputDialog("Qual opção deseja editar? \n1)Preço\n2)Descrição\n3)Qtdade\n4)Categoria"));}
            catch(NumberFormatException io){
                System.err.println("Essa entrada necessita ser um número, tente novamente.");
                editar = Integer.parseInt(JOptionPane.showInputDialog("Qual opção deseja editar? \n1)Preço\n2)Descrição\n3)Qtdade\n4)Categoria"));
            }
            switch (editar) {
                case 1:
                    precoVendaNovo = Double.parseDouble(JOptionPane.showInputDialog("Qual será o novo valor desse produto?"));
                    listProdutos.get(indexLista).setPrecoVenda(precoVendaNovo);
                    break;
                case 2:
                    descricaoNova = JOptionPane.showInputDialog("Digite a nova descrição:");
                    listProdutos.get(indexLista).setDescricao(descricaoNova);
                    break;
                case 3:
                    qtdEstoqNova = Integer.parseInt(JOptionPane.showInputDialog("Entre com a nova quantidade de estoque:"));
                    listProdutos.get(indexLista).setQtdEstoq(qtdEstoqNova);
                    break;
                case 4:
                    categoriaNova = JOptionPane.showInputDialog("Digite a nova categoria:");
                    listProdutos.get(indexLista).setCategoria(categoriaNova);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Entrada inválida.");
                    break;

            }
        } else {
            System.out.println("\nProduto não cadastrado.");
        }

    }

    @Override
    public boolean verificaListaEhVazia() {
        boolean ehVazia = false;
        if (listProdutos.isEmpty()) {
            ehVazia = true;
        }
        return ehVazia;
    }

    @Override
    public boolean buscarProduto(String codigo) {
        boolean resultado = false;
        for (int i = 0; i < listProdutos.size(); i++) {
            if (listProdutos.get(i).getCodigo().equals(codigo)) {
                resultado = true;
            }
        }
        return resultado;
    }

    @Override
    public void listarProdutos() {

        System.out.println("\nLista de produtos cadastrados...");
        System.out.println("\tCódigo | \tNome | \tQtdade | \tDescrição | \tCategoria");
        for (int i = 0; i < listProdutos.size(); i++) {
            System.out.println("\t" + listProdutos.get(i).getCodigo() + "\t |" + listProdutos.get(i).getTitulo() + "\t | " + listProdutos.get(i).getQtdEstoq() + "\t | "
                    + listProdutos.get(i).getDescricao() + "\t | " + listProdutos.get(i).getCategoria());

        }
    }

    @Override
    public double pegarPreco(String codigoProduto) {
        double preco = 0;
        for (int i = 0; i < listProdutos.size(); i++) {
            if (listProdutos.get(i).getCodigo().equals(codigoProduto)) {
                preco = listProdutos.get(i).getPrecoVenda();
            }
        }
        return preco;
    }

}

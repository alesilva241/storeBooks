/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciaLoja;

import interfaces.Venda;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;
import tipos.EnderecoTAD;
import tipos.PessoaTAD;
import tipos.ProdutoLivro;
import tipos.ProdutoTAD;
import tipos.VendaTAD;

/**
 *
 * @author alexandra
 */
public class Vendas implements Venda {

    ArrayList<VendaTAD> listaVendas = new ArrayList<>();
    ArrayList<ProdutoLivro> listProdutos = new ArrayList<>();
    ArrayList<PessoaTAD> listClientes = new ArrayList<>();
    //listas para clonar listas já existentes

    Vendas(Estoque produtos, Cliente clientes) {
        listProdutos = produtos.getListProdutos();
        listClientes = clientes.getListPessoas();
    }
    //construtor para clonar listas

    @Override
    //verifica se existe produto no estoque
    public int verificaDisponibilidadeEstoque(String codigo) {
        int qtdDisponivel = 0;
        System.out.println(listProdutos.size());
        for (int i = 0; i < listProdutos.size(); i++) {
            if (listProdutos.get(i).getCodigo().equals(codigo)) {
                qtdDisponivel = listProdutos.get(i).getQtdEstoq();
            }
        }

        return qtdDisponivel;
    }

    @Override
    //método para remover quantidades do produto a partir de cada venda
    public void removeProduto(String codigo, int qtdComprada) {
        int qtdAntiga;
        for (int i = 0; i < listProdutos.size(); i++) {
            if (listProdutos.get(i).getCodigo().equals(codigo)) {
                qtdAntiga = listProdutos.get(i).getQtdEstoq();
                listProdutos.get(i).setQtdEstoq(qtdAntiga - qtdComprada);
            }
        }

    }

    @Override
    //altera status atraves da indicação do numero
    public void alteraStatus(String codigoVenda) {
        int status;
        System.out.println("\nAlterando status...");
        for (int i = 0; i < listaVendas.size(); i++) {
            if (listaVendas.get(i).getCodigoVenda().equals(codigoVenda)) {
                try {
                    status = Integer.parseInt(JOptionPane.showInputDialog("\n 1)Status pendente \n 2)Status em andamento \n 3) Status entregue"));
                } catch (NumberFormatException io) {
                    System.err.println("Essa entrada precisar ser um inteiro.");
                    status = Integer.parseInt(JOptionPane.showInputDialog("\n 1)Status pendente \n 2)Status em andamento \n 3) Status entregue"));

                }
                switch (status) {
                    case 1:
                        listaVendas.get(i).setStatus("Pedente");
                        break;
                    case 2:
                        listaVendas.get(i).setStatus("Em andamento");
                        break;
                    case 3:
                        listaVendas.get(i).setStatus("Entregue");
                        break;
                    default:
                        System.out.println("Opção inválida, tente novamente.");

                }
            }

        }

    }

    @Override
    public void novaCompra() {

        String codigoProduto, cpfComprador, codigoVenda;
        int qtdDesejada, indexComprador, indexEndereco;
        double preco;
        PessoaTAD comprador;
        EnderecoTAD enderecoEscolhido;
        Date now = new Date();
        DateFormat df = DateFormat.getDateInstance();
        String data = df.format(now);

        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o CPF do comprador");
        cpfComprador = entrada.nextLine();
        System.out.println("Digite o código da mercadoria");
        codigoProduto = entrada.nextLine();
        System.out.println("Digite o código para essa venda");
        codigoVenda = entrada.nextLine();

        if (buscaPessoaCPF(cpfComprador) && buscarProduto(codigoProduto)) {
            System.out.println("\nInicializando compra...");
            System.out.println("Digite a quantidade desejada do produto");
            qtdDesejada = Integer.parseInt(entrada.nextLine());

            if (qtdDesejada > verificaDisponibilidadeEstoque(codigoProduto)) {
                System.out.println("Quantidade insuficiente em nosso estoque.");
            } else {

                indexComprador = localizarPessoa(cpfComprador);
                comprador = listClientes.get(indexComprador);
                indexEndereco = escolhaEndereco(indexComprador);
                enderecoEscolhido = listClientes.get(indexComprador).getListEnderecos().get(indexEndereco);
                preco = pegarPreco(codigoProduto);

                ProdutoTAD produtosCompra = new ProdutoTAD(codigoProduto, qtdDesejada, preco);
                ArrayList<ProdutoTAD> listaPessoa = new ArrayList<>();

                listaPessoa.add(produtosCompra);
                VendaTAD novaVenda = new VendaTAD(codigoVenda, comprador, enderecoEscolhido, listaPessoa, "Pendente", data);
                listaVendas.add(novaVenda);
                removeProduto(codigoProduto, qtdDesejada);
            }
        } else {
            System.out.println("Algo deu errado, verifique o cpf e o código.");
        }

    }

    @Override
    //mostra quantidade de enderecos para que seja possível determinar qual sera o de entrega
    public int escolhaEndereco(int indexComprador) {
        int indexEndereco;
        Scanner escolha = new Scanner(System.in);

        System.out.println("O(A) " + listClientes.get(indexComprador).getNome() + " possui "
                + (listClientes.get(indexComprador).getListEnderecos().size()) + " endereços cadastrados, escolha 1.");
        try {
            indexEndereco = escolha.nextInt();
        } catch (NullPointerException io) {
            System.err.println("Entrada necessita ser inteiro e menor ou igual ao número de endereços disponiveis, tente novamente");
            indexEndereco = escolha.nextInt();
        }
        indexEndereco--;
        return indexEndereco;
    }

    @Override
    public void listarCompras() {
        //mostra alguns itens, os que achei necessario para visualizar as vendas já feitas
        System.out.println("Código \tNome Cliente\t CPF\t Data\t Status \t");
        for (int i = 0; i < listaVendas.size(); i++) {

            System.out.println(listaVendas.get(i).getCodigoVenda() + "\t" + listaVendas.get(i).getComprador().getNome() + "\t" + listaVendas.get(i).getComprador().getCPF() + "\t" + listaVendas.get(i).getData()
                    + "\t" + listaVendas.get(i).getStatus());
        }

    }

    @Override
    public boolean buscarProduto(String codigo) {
        //verifica existencia do produto na lista
        boolean resultado = false;
        for (int i = 0; i < listProdutos.size(); i++) {
            if (listProdutos.get(i).getCodigo().equals(codigo)) {
                resultado = true;
            }
        }
        return resultado;
    }

    @Override
    public boolean buscaPessoaCPF(String cpf) {
        boolean resultado = false;
        for (int i = 0; i < listClientes.size(); i++) {
            if (listClientes.get(i).getCPF().equals(cpf)) {
                resultado = true;
            }
        }
        //To change body of generated methods, choose Tools | Templates.
        return resultado;
    }

    @Override
    public int localizarPessoa(String cpf) {
        int indexPessoa = 0;
        for (int i = 0; i < listClientes.size(); i++) {
            if (listClientes.get(i).getCPF().equals(cpf)) {
                indexPessoa = i;
            }
        }
        return indexPessoa;
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

    @Override
    public boolean verificaListaEhVazia() {
        boolean ehVazia = false;
        if (listProdutos.isEmpty()) {
            ehVazia = true;
        }
        return ehVazia;
    }

}

package gerenciaLoja;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import tipos.EnderecoTAD;
import tipos.PessoaTAD;
import tipos.ProdutoLivro;

public class Main {

    public static void main(String[] args) {
        String rua = null, numero = null, bairro = null, cidade = null, cep = null;
        String codigo = null, cpf = null, nome = null, email = null, CPFeditar;
        String codigoProduto, descricaoProduto, categoriaProduto, codigoEditar, nomeProduto, nomeAutor;
        double precoProduto;
        int opcao, qtdProduto, cadastrarEndereco;
        ArrayList<EnderecoTAD> enderecosPessoa = new ArrayList<>();

        Cliente clientes = new Cliente();
        Estoque produtos = new Estoque();
        Scanner s = new Scanner(System.in);
        Vendas venda = new Vendas(produtos, clientes);
        //System.out.println("\nNovo Cadastro\n");
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(" 1)Para cadastrar cliente \n 2)Para"
                    + " editar cliente \n 3)Lista clientes \n 4)Para cadastrar produto \n "
                    + "5)Para editar um produto \n 6)Listar produtos \n 7)Nova Compra \n 8)Listar Vendas \n 9)Novo Endereço \n 10)Altera Status \n 0)Para sair"));
            switch (opcao) {
                case 0:
                    System.exit(opcao);
                case 1:
                    System.out.println("Entre com seu nome:");
                    nome = s.nextLine();
                    System.out.println("Entre com um código:");
                    codigo = s.nextLine();
                    System.out.println("Entre com um CPF:");
                    cpf = s.nextLine();
                    System.out.println("Entre com um email:");
                    email = s.nextLine();
                    System.out.println("\nAgora vamos cadastrar um primeiro endereço...\n");
                    do {
                        System.out.println("Entre com nome da rua:");
                        rua = s.nextLine();
                        System.out.println("Entre com número:");
                        numero = s.nextLine();
                        System.out.println("Entre com o bairro:");
                        bairro = s.nextLine();
                        System.out.println("Entre com municipio:");
                        cidade = s.nextLine();
                        System.out.println("Entre com cep:");
                        cep = s.nextLine();

                        EnderecoTAD endereco = new EnderecoTAD(rua, numero, bairro, cidade, cep);

                        enderecosPessoa.add(endereco);
                        try {
                            cadastrarEndereco = Integer.parseInt(JOptionPane.showInputDialog("Deseja cadastrar mais um endereço? \nDigite 0 para não"));
                        } catch (NumberFormatException io) {
                            System.err.println("Esta entrada precisa ser um número, tente novamente.");
                            cadastrarEndereco = cadastrarEndereco = Integer.parseInt(JOptionPane.showInputDialog("Deseja cadastrar mais um endereço? \nDigite 0 para não"));
                        }
                    } while (cadastrarEndereco != 0);

                    PessoaTAD pessoa = new PessoaTAD(codigo, cpf, nome, email, enderecosPessoa);

                    clientes.cadastraPessoa(pessoa);
                    break;
                case 2:

                    if (clientes.verificaListaEhVazia()) {
                        JOptionPane.showMessageDialog(null, "Cadastre clientes antes de editá-los.");
                    } else {
                        System.out.println("Entre com o CPF do cliente: ");
                        CPFeditar = s.nextLine();

                        if (clientes.buscaPessoaCPF(CPFeditar)) {
                            clientes.editarPessoa(CPFeditar);
                        } else {
                            JOptionPane.showMessageDialog(null, "CPF não cadastrado.");
                        }
                    }
                    break;
                case 3:
                    clientes.listarPessoa();
                    break;
                case 4:
                    System.out.println("Entre com o código do produto:");
                    codigoProduto = s.nextLine();
                    System.out.println("Entre com o título do livro");
                    nomeProduto = s.nextLine();
                    System.out.println("Entre com o nome do autor");
                    nomeAutor = s.nextLine();
                    System.out.println("Entre com a descrição:");
                    descricaoProduto = s.nextLine();
                    System.out.println("Qual a quantidade deseja cadastrar?");
                    try {
                        qtdProduto = Integer.parseInt(s.nextLine());
                    } catch (NumberFormatException io) {
                        System.err.println("Atenção, a quantidade necessita ser inteira.");
                        System.out.println("Tente novamente...");
                        qtdProduto = Integer.parseInt(s.nextLine());
                    }
                    System.out.println("Qual categoria do produto?");
                    categoriaProduto = s.nextLine();
                    System.out.println("Qual será o preço de venda?");
                    try {
                        precoProduto = Double.parseDouble(s.nextLine());
                    } catch (NumberFormatException io) {
                        System.err.println("Atenção, isso é um preço! Digite um número.");
                        System.out.println("Tente novamente....");
                        precoProduto = Double.parseDouble(s.nextLine());

                    }
                    ProdutoLivro produto = new ProdutoLivro(codigoProduto, descricaoProduto, qtdProduto, categoriaProduto, precoProduto, nomeProduto, nomeAutor);
                    produtos.cadastrarProduto(produto);
                    break;
                case 5:

                    if (produtos.verificaListaEhVazia()) {
                        JOptionPane.showMessageDialog(null, "Cadastre livros antes de editá-los.");
                    } else {
                        System.out.println("Entre com o código do produto:");
                        codigoEditar = s.nextLine();

                        if (produtos.buscarProduto(codigoEditar)) {
                            produtos.editarProduto(codigoEditar);
                        } else {
                            JOptionPane.showMessageDialog(null, "Código não cadastrado");
                        }
                    }
                    break;
                case 6:
                    produtos.listarProdutos();
                    break;
                case 7:
                    if (produtos.verificaListaEhVazia()) {
                        JOptionPane.showMessageDialog(null, "Antes de efetuar compras você deve cadastrar produtos.");
                    } else {
                        venda.novaCompra();
                    }
                    break;
                case 8:
                    venda.listarCompras();
                    break;
                case 9:

                    if (clientes.verificaListaEhVazia()) {
                        JOptionPane.showMessageDialog(null, "Cadastre clientes antes de adicionar endereços.");
                    } else {
                        String cpfNovoEndereco;
                        System.out.println("Entre com o cpf:");
                        cpfNovoEndereco = s.nextLine();
                        clientes.cadastrarMaisEndereco(cpfNovoEndereco);
                    }
                    break;
                case 10:
                    if (venda.verificaListaEhVazia()) {
                        JOptionPane.showMessageDialog(null, "Efetue compras antes de alterar o status.");
                    } else {
                        codigoEditar = JOptionPane.showInputDialog("Entre com o código da compra:");
                        venda.alteraStatus(codigoEditar);
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
                    break;
            }
        } while (opcao != 0);

    }

}

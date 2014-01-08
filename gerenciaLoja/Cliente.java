package gerenciaLoja;

import interfaces.Pessoa;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import tipos.EnderecoTAD;

import tipos.PessoaTAD;

public class Cliente implements Pessoa {

    private ArrayList<PessoaTAD> listPessoas = new ArrayList<>();

    public ArrayList<PessoaTAD> getListPessoas() {
        return listPessoas;
    }

    public void setListPessoas(ArrayList<PessoaTAD> listPessoas) {
        this.listPessoas = listPessoas;
    }

    @Override
    public void editarPessoa(String CPF) {

        Scanner s = new Scanner(System.in);
        String nomeNovo, emailNovo;

        int editar;
        int indexLista = 0;
        boolean verifica = false;
        for (int i = 0; i < listPessoas.size(); i++) {
            if (listPessoas.get(i).getCPF().equals(CPF)) {
                verifica = true;
                indexLista = i;
            }
        }
        if (verifica) {
            System.out.println("\nUsuário na posição " + indexLista + 1);
            System.out.println("\n Preparando para editar...");
            try {
                editar = Integer.parseInt(JOptionPane.showInputDialog("Qual opção deseja editar?\n1)Nome \n2)Email"));
            } catch (NumberFormatException io) {
                System.err.println("Tente novamente, agora com um inteiro.");
                editar = Integer.parseInt(JOptionPane.showInputDialog("Qual opção deseja editar?\n1)Nome \n2)Email"));

            }
            switch (editar) {

                case 1:
                    nomeNovo = JOptionPane.showInputDialog("Entre com o nome para atualizar");
                    listPessoas.get(indexLista).setNome(nomeNovo);
                    break;
                case 2:
                    emailNovo = JOptionPane.showInputDialog("Entre com o e-mail para atualizar");
                    listPessoas.get(indexLista).setEmail(emailNovo);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
                    break;
            }

        } else {
            System.out.println("\nUsuário inexistente.");
        }

    }

    @Override
    public void listarPessoa() {
        // TODO Auto-generated method stub
        System.out.println("\tNome | \tCPF | \tEmail | \tEndereços ");
        //System.out.println(teste.getNome());
        for (int i = 0; i < listPessoas.size(); i++) {
            System.out.println("\t" + listPessoas.get(i).getNome() + "\t" + listPessoas.get(i).getCPF() + "\t" + listPessoas.get(i).getEmail());
            //System.out.println(listPessoas.get(i).getCodigo());
            System.out.println("Número de endereços: " + listPessoas.get(i).getListEnderecos().size());
            for (int j = 0; j < listPessoas.get(i).getListEnderecos().size(); j++) {
                System.out.println(listPessoas.get(i).getListEnderecos().get(j).getRua() + ", " + listPessoas.get(i).getListEnderecos().get(j).getNumero() + ", "
                        + listPessoas.get(i).getListEnderecos().get(j).getBairro() + ", " + listPessoas.get(i).getListEnderecos().get(j).getMunicipio() + ", "
                        + listPessoas.get(i).getListEnderecos().get(j).getCep());
            }

        }
    }

    @Override
    public void cadastraPessoa(PessoaTAD pessoa) {
        if (buscaPessoa(pessoa)) {
            System.out.println("\n" + pessoa.getNome() + " já cadastrado(a) no sistema.");
        } else {
            listPessoas.add(pessoa);// TODO Auto-generated method stub
        }
    }

    @Override
    public boolean buscaPessoa(PessoaTAD pessoa) {
        boolean resultado = false;

        for (int i = 0; i < listPessoas.size(); i++) {
            if (listPessoas.get(i).getCPF().equals(pessoa.getCPF()) || listPessoas.get(i).getEmail().equals(pessoa.getEmail())) {
                resultado = true;
            }
        }
        // TODO Auto-generated method stub
        return resultado;
    }

    @Override
    public boolean buscaPessoaCPF(String cpf) {
        boolean resultado = false;
        for (int i = 0; i < listPessoas.size(); i++) {
            if (listPessoas.get(i).getCPF().equals(cpf)) {
                resultado = true;
            }
        }
        //To change body of generated methods, choose Tools | Templates.
        return resultado;
    }

    @Override
    public int localizarPessoa(String cpf) {
        int indexPessoa = 0;
        for (int i = 0; i < listPessoas.size(); i++) {
            if (listPessoas.get(i).getCPF().equals(cpf)) {
                indexPessoa = i;
            }
        }
        return indexPessoa;
    }

    @Override
    public void cadastrarMaisEndereco(String cpf) {
        //System.out.println("\nAgora vamos cadastrar um primeiro endereço...\n\n");
        Scanner s = new Scanner(System.in);
        String rua = null, numero = null, bairro = null, cidade = null, cep = null;
        int cadastrarEndereco;
        int indexCliente;

        indexCliente = localizarPessoa(cpf);

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

            listPessoas.get(indexCliente).getListEnderecos().add(endereco);

            try {
                cadastrarEndereco = Integer.parseInt(JOptionPane.showInputDialog("Deseja cadastrar mais um endereço? \nDigite 0 para não"));
            } catch (NumberFormatException io) {
                System.err.println("Entre com inteiros, tente novamente.");
                cadastrarEndereco = Integer.parseInt(JOptionPane.showInputDialog("Deseja cadastrar mais um endereço? \nDigite 0 para não"));
            }
        } while (cadastrarEndereco != 0);

    }

    @Override
    public boolean verificaListaEhVazia() {
        boolean ehVazia = false;
        if (listPessoas.isEmpty()) {
            ehVazia = true;
        }
        return ehVazia;
    }

}

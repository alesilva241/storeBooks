package tipos;

import java.util.ArrayList;

public class PessoaTAD {

    private String codigo;
    private String CPF;
    private String nome;
    private String email;
    private ArrayList<EnderecoTAD> listEnderecos;

    public PessoaTAD(String codigo, String CPF, String nome, String email, ArrayList<EnderecoTAD> listEnderecos) {
        this.codigo = codigo;
        this.CPF = CPF;
        this.nome = nome;
        this.email = email;
        this.listEnderecos = listEnderecos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<EnderecoTAD> getListEnderecos() {
        return listEnderecos;
    }

    public void setListEnderecos(ArrayList<EnderecoTAD> listEnderecos) {
        this.listEnderecos = listEnderecos;
    }
    
}

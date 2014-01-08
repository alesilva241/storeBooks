package interfaces;

import tipos.PessoaTAD;

public interface Pessoa {
	
	public boolean buscaPessoa(PessoaTAD pessoa);
        public boolean verificaListaEhVazia();
        public boolean buscaPessoaCPF(String cpf);
        public int localizarPessoa(String cpf);
	public void cadastraPessoa(PessoaTAD pessoa);
        public void cadastrarMaisEndereco(String cpf);
	public void editarPessoa(String CPF);	
	public void listarPessoa();
       
}

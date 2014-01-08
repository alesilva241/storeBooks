package tipos;

public class EnderecoTAD {

    private String rua;
    private String numero;
    private String bairro;
    private String municipio;
    private String cep;

    public EnderecoTAD(String rua, String numero, String bairro, String municipio, String cep) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.municipio = municipio;
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

}

package mobile.pitagoras.imc.utils;

public class PessoaIMC {
    public String nome;
    public Double peso;
    public Double altura;
    public Double imc;
    public String classificacao;

    public PessoaIMC(String nome, Double peso, Double altura, Double imc, String classificacao) {
        this.nome = nome;
        this.peso = peso;
        this.altura = altura;
        this.imc = imc;
        this.classificacao = classificacao;
    }

}

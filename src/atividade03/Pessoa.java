package atividade03;

public class Pessoa {
    private int idade;
    private long cpf;
    private String nome;
    
   
    Pessoa(int idade, long cpf, String nome) {
        this.idade = idade;
        this.cpf = cpf;
        this.nome = nome;
    }
    
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Pessoa pessoa = (Pessoa) obj;
        return cpf == pessoa.cpf;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(cpf);
    }
    
    @Override
	public String toString() {
		return String.valueOf(cpf);
	}
}

package br.com.infox.entidades;

public abstract class Pessoa {
    
    private String nome;
    private String fone;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    @Override
    public String toString() {
        return "nome=" + nome + ", fone=" + fone;
    }
    
}

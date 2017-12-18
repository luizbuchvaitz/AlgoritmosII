
package br.com.infox.entidades;

public class Cliente extends Pessoa {
    
    private String email;
    private String endereco;
    
    public Cliente (String nome, String fone, String email, String endereco) {
        setNome(nome);
        setFone(fone);
        setEmail(email);
        setEndereco(endereco);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Cliente{" + super.toString() + ", email=" + email + ", endereco=" + endereco + '}';
    }
    
}

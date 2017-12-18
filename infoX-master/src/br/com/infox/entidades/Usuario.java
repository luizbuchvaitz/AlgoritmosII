// herança e polimorfismo
package br.com.infox.entidades;

public class Usuario extends Pessoa {
    
    private String login;
    private String senha;
    private String perfil;
    
    public Usuario (String nome, String fone, String login, String senha, String perfil) {
        setNome(nome);
        setFone(fone);
        setLogin(login);
        setSenha(senha);
        setPerfil(perfil);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        return "Usuario{" + super.toString() + ", login=" + login + ", senha=" + senha + ", perfil=" + perfil + '}';
    }
}

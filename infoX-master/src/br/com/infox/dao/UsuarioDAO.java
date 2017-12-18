/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.dao;

import br.com.infox.conexao.ModuloConexao;
import br.com.infox.entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {
    
    //  usando a variavel de conexao
    private Connection conexao = ModuloConexao.conector();
    // criando variáveis especiais para conexão com o banco
    //Prepared Statement e ResultSet são frameworks do pacote java.sql
    // e servem para preparar e executar as instruções SQL
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    
    //criando o metodo logar
    public Object logar (String login, String senha) {
        //logica principal para pesquisar no banco de dados
        String sql = "select * from tbusuarios where login = ? and senha = ?";
        try {
            //as linhas abaixo preparam a consulta em função do que foi 
            //digitado nas caixas de texto. O ? é substituído pelo conteúdo
            //das variáveis que são armazenadas em pst.setString
            pst = conexao.prepareStatement(sql);
            pst.setString(1, login);
            pst.setString(2, senha);
            //a linha abaixo executa a query(consulta)
            rs = pst.executeQuery();
            //se existir um usuário e senha correspondente
            if (rs.next()) {
                
                String nome = rs.getString(2);
                String fone = rs.getString(3);
                String perfil = rs.getString(6);
                
                Usuario user = new Usuario(nome, fone, login, senha, perfil);
                
                return user;
            } else {
                return "usuário e/ou senha inválido(s)";
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.dao;

import br.com.infox.conexao.ModuloConexao;
import br.com.infox.entidades.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO {
    
    //  usando a variavel de conexao
    private Connection conexao = ModuloConexao.conector();
    // criando variáveis especiais para conexão com o banco
    //Prepared Statement e ResultSet são frameworks do pacote java.sql
    // e servem para preparar e executar as instruções SQL
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    
    //método para adicionar clientes
    public String adicionar(Cliente cliente) {
        String sql = "insert into tbclientes(nomecli,endcli,fonecli,emailcli) values(?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getEndereco());
            pst.setString(3, cliente.getFone());
            pst.setString(4, cliente.getEmail());
            //a linha abaixo atualiza a tabela usuario com os dados do formulário
            //a etrutura abaixo é usada para confirmar a inserção dos dados na tabela
            int adicionado = pst.executeUpdate();

            return (adicionado > 0) ? "Cliente adicionado com sucesso" : "Erro ao adicionar cliente";
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    //método para pesquisar clientes pelo nome com filtro
    public ArrayList<Cliente> pesquisar_cliente(String strNome) {
        String sql = "select * from tbclientes where nomecli like ?";
        try {
            
            ArrayList<Cliente> clientes = new ArrayList();
            
            pst = conexao.prepareStatement(sql);
            //passando o conteúdo da caixa de pesquisa para o ?
            //atenção ao "%" - continuação da String sql
            pst.setString(1, strNome + "%");
            rs = pst.executeQuery();
            
            while (rs.next()) {
                
                String nome = rs.getString(2);
                String endereco = rs.getString(3);
                String fone = rs.getString(4);
                String email = rs.getString(5);
                
                clientes.add(new Cliente(nome, fone, email, endereco));
            }
            return clientes;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    // método para obter a lista total de clientes
    public ArrayList<Cliente> listar_clientes() {
        String sql = "select * from tbclientes";
        try {
            
            ArrayList<Cliente> clientes = new ArrayList();
            
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while (rs.next()) {
                
                String nome = rs.getString(2);
                String endereco = rs.getString(3);
                String fone = rs.getString(4);
                String email = rs.getString(5);
                
                clientes.add(new Cliente(nome, fone, email, endereco));
            }
            return clientes;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    // método para alterar dados do cliente
    public String alterar(String emailAnt, Cliente cliente) {
        String sql = "update tbclientes set nomecli=?,endcli=?,fonecli=?,emailcli=? where emailcli=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getEndereco());
            pst.setString(3, cliente.getFone());
            pst.setString(4, cliente.getEmail());
            pst.setString(5, emailAnt);

            //a linha abaixo atualiza a tabela cliente com os dados do formulário
            //a etrutura abaixo é usada para confirmar a alteração dos dados na tabela
            int adicionado = pst.executeUpdate();

            return (adicionado > 0) ? "Cliente alterado com sucesso" : "Erro ao alterar cliente";
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    // método responsável pela remoção de clientes

    public String remover(int id) {
        String sql = "delete from tbclientes where idcli=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);
            int apagado = pst.executeUpdate();
            return (apagado > 0) ? "Cliente apagado com sucesso" : "Erro ao apagar cliente";
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}

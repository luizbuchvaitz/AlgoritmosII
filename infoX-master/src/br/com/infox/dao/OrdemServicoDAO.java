/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.dao;

import br.com.infox.conexao.ModuloConexao;
import br.com.infox.entidades.Cliente;
import br.com.infox.entidades.OrdemServico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class OrdemServicoDAO {
    
    //  usando a variavel de conexao
    private Connection conexao = ModuloConexao.conector();
    // criando variáveis especiais para conexão com o banco
    //Prepared Statement e ResultSet são frameworks do pacote java.sql
    // e servem para preparar e executar as instruções SQL
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    
    // método para cadastrar uma OS
    public String emitir_os(OrdemServico os, int idCliente) {
        String sql = "insert into tbos(tipo,situacao,equipamento,defeito,servico,tecnico,valor,idcli) values(?,?,?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, os.getTipo());
            pst.setString(2, os.getSituacao());
            pst.setString(3, os.getEquipamento());
            pst.setString(4, os.getDefeito());
            pst.setString(5, os.getServico());
            pst.setString(6, os.getTecnico());
            pst.setDouble(7, os.getValor());
            pst.setInt(8, idCliente);
            
            int adicionado = pst.executeUpdate();
            return (adicionado > 0) ? "OS emitida com sucesso" : "Erro ao emitir OS";

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    
    // método para pesquisar uma os
    public OrdemServico pesquisar_os(int numOS) {
        String sql = "select * from tbos where os=?";
        String sql1 = "select * from tbclientes, tbos where tbclientes.idcli = tbos.idcli and tbos.os=?";
        try {
            
            OrdemServico os = new OrdemServico();
            
            pst = conexao.prepareStatement(sql);
            
            pst.setInt(1, numOS);
            rs = pst.executeQuery();
            
            if (rs.next()) {
                
                String data = rs.getString(2);
                String tipo = rs.getString(3);
                String situacao = rs.getString(4);
                String equipamento = rs.getString(5);
                String defeito = rs.getString(6);
                String servico = rs.getString(7);
                String tecnico = rs.getString(8);
                double valor = rs.getDouble(9);
                
                os = new OrdemServico(tipo, situacao, equipamento, defeito, servico, tecnico, valor);
                os.setData(data);
            }
            
            pst = conexao.prepareStatement(sql1);
            
            pst.setInt(1, numOS);
            rs = pst.executeQuery();
            
            if (rs.next()) {
                
                String nome = rs.getString(2);
                String endereco = rs.getString(3);
                String fone = rs.getString(4);
                String email = rs.getString(5);
                
                os.setCliente(new Cliente(nome, fone, email, endereco));
            }
            return os;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    
    //método para alterar uma OS
    public String alterar_os(int id, OrdemServico os) {
        String sql = "update tbos set tipo=?,situacao=?,equipamento=?,defeito=?,servico=?,tecnico=?,valor=? where os=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, os.getTipo());
            pst.setString(2, os.getSituacao());
            pst.setString(3, os.getEquipamento());
            pst.setString(4, os.getDefeito());
            pst.setString(5, os.getServico());
            pst.setString(6, os.getTecnico());
            pst.setDouble(7, os.getValor());
            pst.setInt(8, id);

            int adicionado = pst.executeUpdate();
            return (adicionado > 0) ? "OS alterada com sucesso" : "Erro ao alterar OS";

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    
    //método para excluir uma os
    public String excluir_os(int id) {
        String sql = "delete from tbos where os=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);
            int apagado = pst.executeUpdate();
            return (apagado > 0) ? "OS apagada com sucesso" : "Erro ao apagar OS";
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}

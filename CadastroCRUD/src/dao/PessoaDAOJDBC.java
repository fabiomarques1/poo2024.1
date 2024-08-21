/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Pessoa;


/**
 *
 * @author fmacz
 */
public class PessoaDAOJDBC implements PessoaDAO {
    
    @Override
    public int inserir(Pessoa pessoa) {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("INSERT INTO pessoa(nome, data_nascimento) ")
                .append("VALUES (?, ?)");
     
        String insert = sqlBuilder.toString();
        int linha = 0;
        try {  
            linha = DAOGenerico.executarComando(insert, pessoa.getNome(), pessoa.getDataNascimento());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return linha;
    }

    @Override
    public int editar(Pessoa pessoa) {
      StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("UPDATE pessoa SET ")
                .append("nome = ?, ")
                .append("data_nascimento = ? ")
                .append("WHERE codigo = ?");
        String update = sqlBuilder.toString();
        int linha = 0;
        try {
            linha = DAOGenerico.executarComando(update, pessoa.getNome(), pessoa.getDataNascimento(), pessoa.getCodigo());
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return linha; 
    }

    @Override
    public int apagar(int codigo) throws ClassNotFoundException, SQLException, SQLIntegrityConstraintViolationException {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("DELETE FROM pessoa ")
                .append("WHERE codigo = ?");
        String delete = sqlBuilder.toString();
        int linha = 0;        
        linha = DAOGenerico.executarComando(delete, codigo);
        return linha;
    }

    @Override
    public List<Pessoa> listar() {
        ResultSet rset;
        String select = "SELECT * FROM pessoa";
        List<Pessoa> pessoas = new ArrayList<>();
        try {        
            rset = DAOGenerico.executarConsulta(select);
            while (rset.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setCodigo(rset.getInt("codigo"));
                pessoa.setNome(rset.getString("nome"));
                pessoa.setDataNascimento(rset.getDate("data_nascimento"));
                pessoas.add(pessoa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return pessoas;
    }

    @Override
    public Pessoa listar(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

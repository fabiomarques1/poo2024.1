package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Lutador;

public class LutadorDAOJDBC implements LutadorDAO {
    
    @Override
    public int inserir(Lutador lutador) {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("insert into lutador(nome, nacionalidade, idade, altura, peso) ")
                .append("VALUES (?, ?, ?, ?, ?)");
     
        String insert = sqlBuilder.toString();
        int linha = 0;
        try {  
            linha = DAOGenerico.executarComando(insert, lutador.getNome(),
                                                        lutador.getNacionalidade(),
                                                        lutador.getIdade(),
                                                        lutador.getAltura(),
                                                        lutador.getPeso()
                                                        );
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return linha;
    }

    @Override
    public int editar(Lutador lutador) {
      StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("UPDATE lutador SET ")
                .append("nome = ?, ")
                .append("nacionalidade = ?, ")
                .append("idade = ?, ")
                .append("altura = ?, ")
                .append("peso = ? ")
                .append("WHERE codigo = ?");
        String update = sqlBuilder.toString();
        int linha = 0;
        try {
            linha = DAOGenerico.executarComando(update, lutador.getNome(), 
                                                        lutador.getNacionalidade(),
                                                        lutador.getIdade(),
                                                        lutador.getAltura(),
                                                        lutador.getPeso(),
                                                        lutador.getCodigo());
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return linha; 
    }

    @Override
    public int apagar(int codigo) throws ClassNotFoundException, SQLException, SQLIntegrityConstraintViolationException {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("DELETE FROM lutador ")
                .append("WHERE codigo = ?");
        String delete = sqlBuilder.toString();
        int linha = 0;        
        linha = DAOGenerico.executarComando(delete, codigo);
        return linha;
    }

    @Override
    public List<Lutador> listar() {
        ResultSet rset;
        String select = "SELECT * FROM lutador ORDER BY nome";
        List<Lutador> lutadores = new ArrayList<>();
        try {        
            rset = DAOGenerico.executarConsulta(select);
            while (rset.next()) {
                Lutador lutador = new Lutador();
                lutador.setCodigo(rset.getInt("codigo"));
                lutador.setNome(rset.getString("nome"));
                lutador.setNacionalidade(rset.getString("nacionalidade"));
                lutador.setIdade(rset.getInt("idade"));
                lutador.setAltura(rset.getFloat("altura"));
                lutador.setPeso(rset.getFloat("peso"));
                lutador.setCategoria();
                lutador.setVitorias(rset.getInt("vitorias"));
                lutador.setEmpates(rset.getInt("empates"));
                lutador.setDerrotas(rset.getInt("derrotas"));
                lutadores.add(lutador);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return lutadores;
    }

    @Override
    public Lutador listar(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int empatarLuta(int codigo) {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("UPDATE lutador SET ")
                .append("empates = empates + 1 ")
                .append("WHERE codigo = ?");
        String update = sqlBuilder.toString();
        int linha = 0;
        try {
            linha = DAOGenerico.executarComando(update, codigo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linha;
    }

    @Override
    public int ganharLuta(int codigo) {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("UPDATE lutador SET ")
                .append("vitorias = vitorias + 1 ")
                .append("WHERE codigo = ?");
        String update = sqlBuilder.toString();
        int linha = 0;
        try {
            linha = DAOGenerico.executarComando(update, codigo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linha;
    }

    @Override
    public int perderLuta(int codigo) {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("UPDATE lutador SET ")
                .append("derrotas = derrotas + 1 ")
                .append("WHERE codigo = ?");
        String update = sqlBuilder.toString();
        int linha = 0;
        try {
            linha = DAOGenerico.executarComando(update, codigo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linha;
    }
    
}

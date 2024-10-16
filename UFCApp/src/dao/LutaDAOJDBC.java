package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Luta;
import modelo.Lutador;

public class LutaDAOJDBC implements LutaDAO {
    
    @Override
    public int inserir(Luta luta) {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("insert into luta (data_hora, desafiado, desafiante, partidas) ")
                .append("VALUES (?, ?, ?, ?)");
     
        String insert = sqlBuilder.toString();
        int linha = 0;
        try {  
            linha = DAOGenerico.executarComando(insert, luta.getDataHora(),
                                                        luta.getDesafiado().getCodigo(),
                                                        luta.getDesafiante().getCodigo(),
                                                        luta.getPartidas());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return linha;
    }

    @Override
    public int editar(Luta luta) {
      StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("UPDATE luta SET ")
                .append("data_hora = ?, ")
                .append("desafiado = ?, ")
                .append("desafiante = ?, ")
                .append("partidas = ? ")
                .append("WHERE codigo = ?");
        String update = sqlBuilder.toString();
        int linha = 0;
        try {
            linha = DAOGenerico.executarComando(update, luta.getDataHora(),
                                                        luta.getDesafiado().getCodigo(),
                                                        luta.getDesafiante().getCodigo(),
                                                        luta.getPartidas());       
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return linha; 
    }

    @Override
    public int apagar(int codigo) throws ClassNotFoundException, SQLException, SQLIntegrityConstraintViolationException {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("DELETE FROM luta ")
                .append("WHERE codigo = ?");
        String delete = sqlBuilder.toString();
        int linha = 0;        
        linha = DAOGenerico.executarComando(delete, codigo);
        return linha;
    }

    @Override
    public List<Luta> listar() {
        ResultSet rset;
        String select = "SELECT * FROM luta_lutador";
        List<Luta> lutas = new ArrayList<>();
        try {        
            rset = DAOGenerico.executarConsulta(select);
            while (rset.next()) {
                Luta luta = new Luta();
                luta.setCodigo(rset.getInt("cod_luta"));
                luta.setDataHora(rset.getTimestamp("data_hora"));
                
                Lutador desafiado = new Lutador();
                desafiado.setCodigo(rset.getInt("cod_dso"));
                desafiado.setNome(rset.getString("nome_dso"));
                desafiado.setNacionalidade(rset.getString("nacionalidade_dso"));
                desafiado.setIdade(rset.getInt("idade_dso"));
                desafiado.setAltura(rset.getFloat("altura_dso"));
                desafiado.setPeso(rset.getFloat("peso_dso"));
                desafiado.setCategoria();
                desafiado.setVitorias(rset.getInt("vitorias_dso"));
                desafiado.setEmpates(rset.getInt("empates_dso"));
                desafiado.setDerrotas(rset.getInt("derrotas_dso"));
                luta.setDesafiado(desafiado);
                
                Lutador desafiante = new Lutador();
                desafiante.setCodigo(rset.getInt("cod_dft"));
                desafiante.setNome(rset.getString("nome_dft"));
                desafiante.setNacionalidade(rset.getString("nacionalidade_dft"));
                desafiante.setIdade(rset.getInt("idade_dft"));
                desafiante.setAltura(rset.getFloat("altura_dft"));
                desafiante.setPeso(rset.getFloat("peso_dft"));
                desafiante.setCategoria();
                desafiante.setVitorias(rset.getInt("vitorias_dft"));
                desafiante.setEmpates(rset.getInt("empates_dft"));
                desafiante.setDerrotas(rset.getInt("derrotas_dft"));
                luta.setDesafiante(desafiante);
                
                luta.setPartidas(rset.getInt("partidas"));
                luta.setAprovada(rset.getBoolean("aprovada"));
                lutas.add(luta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return lutas;
    }

    @Override
    public Luta listar(int codigo) {
        ResultSet rset;
        String select = "SELECT * FROM luta_lutador WHERE cod_luta = ?";
        Luta luta = new Luta();
        try {        
            rset = DAOGenerico.executarConsulta(select, codigo);
            while (rset.next()) {
                luta.setCodigo(rset.getInt("cod_luta"));
                luta.setDataHora(rset.getTimestamp("data_hora"));
                
                Lutador desafiado = new Lutador();
                desafiado.setCodigo(rset.getInt("cod_dso"));
                desafiado.setNome(rset.getString("nome_dso"));
                desafiado.setNacionalidade(rset.getString("nacionalidade_dso"));
                desafiado.setIdade(rset.getInt("idade_dso"));
                desafiado.setAltura(rset.getFloat("altura_dso"));
                desafiado.setPeso(rset.getFloat("peso_dso"));
                desafiado.setCategoria();
                desafiado.setVitorias(rset.getInt("vitorias_dso"));
                desafiado.setEmpates(rset.getInt("empates_dso"));
                desafiado.setDerrotas(rset.getInt("derrotas_dso"));
                luta.setDesafiado(desafiado);
                
                Lutador desafiante = new Lutador();
                desafiante.setCodigo(rset.getInt("cod_dft"));
                desafiante.setNome(rset.getString("nome_dft"));
                desafiante.setNacionalidade(rset.getString("nacionalidade_dft"));
                desafiante.setIdade(rset.getInt("idade_dft"));
                desafiante.setAltura(rset.getFloat("altura_dft"));
                desafiante.setPeso(rset.getFloat("peso_dft"));
                desafiante.setCategoria();
                desafiante.setVitorias(rset.getInt("vitorias_dft"));
                desafiante.setEmpates(rset.getInt("empates_dft"));
                desafiante.setDerrotas(rset.getInt("derrotas_dft"));
                luta.setDesafiante(desafiante);
                
                luta.setPartidas(rset.getInt("partidas"));
                luta.setAprovada(rset.getBoolean("aprovada"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return luta;
    }

    @Override
    public int aprovarLuta(int codigo) {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("UPDATE luta SET ")
                .append("aprovada = true ")
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

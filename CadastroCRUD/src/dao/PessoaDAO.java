/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import modelo.Pessoa;
import java.sql.*;

/**
 *
 * @author fmacz
 */
public interface PessoaDAO {
    public int inserir(Pessoa pessoa);
    public int editar(Pessoa pessoa);
    public int apagar(int codigo) throws ClassNotFoundException, SQLException, SQLIntegrityConstraintViolationException;
    public List<Pessoa> listar();
    public Pessoa listar(int codigo);
}

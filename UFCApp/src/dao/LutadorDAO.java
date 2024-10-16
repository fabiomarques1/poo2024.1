package dao;

import java.util.List;
import modelo.Lutador;
import java.sql.*;

public interface LutadorDAO {
    public int inserir(Lutador lutador);
    public int editar(Lutador lutador);
    public int apagar(int codigo) throws ClassNotFoundException, SQLException, SQLIntegrityConstraintViolationException;
    public List<Lutador> listar();
    public Lutador listar(int codigo);
    public int empatarLuta(int codigo);
    public int ganharLuta(int codigo);
    public int perderLuta(int codigo);
}

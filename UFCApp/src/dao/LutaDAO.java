package dao;

import java.util.List;
import modelo.Luta;
import java.sql.*;

public interface LutaDAO {
    public int inserir(Luta luta);
    public int editar(Luta luta);
    public int apagar(int codigo) throws ClassNotFoundException, SQLException, SQLIntegrityConstraintViolationException;
    public List<Luta> listar();
    public Luta listar(int codigo);
    public int aprovarLuta(int codigo);
}

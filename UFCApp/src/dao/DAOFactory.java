package dao;

public class DAOFactory {
    public static LutadorDAO criarLutadorDAO() {
        return new LutadorDAOJDBC();
    }
    
    public static LutaDAO criarLutaDAO() {
        return new LutaDAOJDBC();
    }
}

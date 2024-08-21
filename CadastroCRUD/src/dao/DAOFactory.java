/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author fmacz
 */
public class DAOFactory {
    public static PessoaDAO criarPessoaDAO() {
        return new PessoaDAOJDBC();
    }
}

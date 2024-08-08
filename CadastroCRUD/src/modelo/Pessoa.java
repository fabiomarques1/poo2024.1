
package modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Pessoa {
    
    private int codigo;
    private String nome;
    private Date dataNascimento;
    
    int calcularIdade() {
        Calendar dataNasc = Calendar.getInstance();
        dataNasc.setTime(dataNascimento);
        
        Calendar hoje = Calendar.getInstance();
        hoje.getTime();
        
        int idade = hoje.get(Calendar.YEAR) - dataNasc.get(Calendar.YEAR);
        
        dataNasc.add(Calendar.YEAR, idade);
        
        if (hoje.before(dataNasc)) {
            idade--;
        }
        
        
        return idade;
        
    }
   

    @Override
    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return "Pessoa{" + "nome=" + nome + ", dataNascimento=" + formato.format(dataNascimento) + '}';
    }
    
    String imprimir() {
        return "Nome: " + nome + "\nIdade: " + calcularIdade();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
}

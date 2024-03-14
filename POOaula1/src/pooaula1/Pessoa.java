
package pooaula1;

import java.util.Calendar;
import java.util.Date;

public class Pessoa {
    
    String nome;
    Date dataNascimento;
    
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
    
    String imprimir() {
        return "Nome: " + nome + "\nIdade: " + calcularIdade();
    }
    
}

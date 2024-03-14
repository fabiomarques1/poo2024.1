package pooaula1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {

    //método principal 
    public static void main(String[] args) {
        //Criar objeto Pessoa;
        Pessoa p = new Pessoa();
        //Criar o objeto Scanner para ler do teclado
        Scanner teclado = new Scanner(System.in);
        //Ler a variável nome
        loop: do {
            System.out.println("Informe o nome: (Digite SAIR para finalizar)");
            p.nome = teclado.next();
            if (p.nome.equalsIgnoreCase("sair")) {
                break loop;
            }

            //Ler a variável data de nascimento
            boolean erro = true;
            do {
                System.out.println("Informe a Data de Nascimento: ");
                String dataTexto = teclado.next();
                //Converter de String para Date
                SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
                formatoData.setLenient(false);
                try {
                    p.dataNascimento = formatoData.parse(dataTexto);
                    Calendar dataNasc = Calendar.getInstance();
                    dataNasc.setTime(p.dataNascimento);
                    Calendar hoje = Calendar.getInstance();
                    hoje.getTime();
                    if (hoje.after(dataNasc)) {
                        erro = false;
                    }

                } catch (ParseException ex) {
                    System.out.println("Data Inválida: " + dataTexto);
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            } while (erro);
            //Imprimir os dados solicitados
            System.out.println(p.imprimir());
        } while (true);
        
    }
    
}

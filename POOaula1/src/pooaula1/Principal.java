package pooaula1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {

    //método principal 
    public static void main(String[] args) {
        //Criar Lista Pessoas
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        //Criar o objeto Scanner para ler do teclado
        Scanner teclado = new Scanner(System.in);
        //loop principal
        loop: do {
            //Criar objeto Pessoa;
            Pessoa p = new Pessoa();
            //Ler a variável nome
            System.out.println("Informe o nome: (Digite SAIR para finalizar)");
            p.nome = teclado.next();
            //Quebrar o loop se digitar sair
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
                    if (hoje.after(dataNasc) || hoje.equals(dataNasc)) {
                        erro = false;
                    }

                } catch (ParseException ex) {
                    System.out.println("Data Inválida: " + dataTexto);
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            } while (erro);
            //Adicionar pessoa à lista
            pessoas.add(p);
            //Imprimir os dados solicitados
            System.out.println(p.imprimir());
        } while (true);
        
        //Classificar por nome
        Collections.sort(pessoas, new Comparator<Pessoa>() {
            @Override
            public int compare(Pessoa a, Pessoa b) {
                return a.nome.compareTo(b.nome);
            }
        });
        //Imprimir lista
        for(Pessoa p : pessoas) {
            System.out.println(p);
        }
        
        SumarioPessoa sumario = new SumarioPessoa();
        sumario = sumario.sumarizar(pessoas);
        //Imprimir dados sumarizados
        System.out.println("Qtde de pessoas: " + sumario.cont);
        System.out.println("Média das idades:" + sumario.media);
        System.out.println("Maior Idade: " + sumario.maior);
        System.out.println(sumario.nomeMaior + " possui a maior idade.");
        System.out.println("Menor Idade: " + sumario.menor);
        System.out.println(sumario.nomeMenor + " possui a menor idade.");
        System.out.printf("Perc. de Pessoas Menor de idade: %.1f%%%n", (float) sumario.percMenor);
        System.out.printf("Perc. de Pessoas Maior de idade: %.1f%%%n", (float) sumario.percMaior);
    }
    
}

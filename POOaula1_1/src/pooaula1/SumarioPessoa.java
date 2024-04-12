
package pooaula1;

import java.util.ArrayList;


public class SumarioPessoa {
    //Iniciar variáveis de sumarização dos dados
    int cont = 0, soma = 0, maior = Integer.MIN_VALUE, 
    menor = Integer.MAX_VALUE, contMenor = 0, contMaior = 0;
    float media = 0, percMenor = 0, percMaior;
    String nomeMenor = null, nomeMaior = null;
    
    public SumarioPessoa sumarizar(ArrayList<Pessoa> pessoas) {
        //Processamento das variváveis de sumarização
        for (Pessoa p : pessoas) {
            cont++;
            int idade = p.calcularIdade();
            soma = soma + idade;
            if (maior < idade) {
                maior = idade;
                nomeMaior = p.nome;
            }
            if (menor > idade) {
                menor = idade;
                nomeMenor = p.nome;
            }
            if (idade < 18) {
                contMenor++;
            } else {
                contMaior++;
            }
        }
        media = (float) soma/cont;
        percMenor = (float) contMenor/cont * 100;
        percMaior = (float) contMaior/cont * 100;
        return this;
    }

    @Override
    public String toString() {
        return "SumarioPessoa{" + "cont=" + cont + ", soma=" + soma + ", maior=" + maior + ", menor=" + menor + ", contMenor=" + contMenor + ", contMaior=" + contMaior + ", nomeMenor=" + nomeMenor + ", nomeMaior=" + nomeMaior + '}';
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade1;

/**
 *
 * @author vitor
 */
public class AlgoritmosPI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*double matriz[][] = {{0.1, 0.2, 0.1, 0.2, 0.1},
                             {0.1, 0.2, 0.3, 0.1, 0.1},
                             {0.2, 0.3, 0.1, 0.1, 0.3},
                             {0.4, 0.1, 0.1, 0.1, 0.2},
                             {0.2, 0.2, 0.3, 0.3, 0.1}};*/
        double matriz[][] =        {{0.1, 0.1, 0.1, 0.1, 0.1, 0.1 , 0.1, 0.1 , 0.1 , 0.1},
                                    {0.2, 0.2, 0.2, 0.2, 0.2, 0.2, 0.2, 0.2, 0.2, 0.2},
                                    {0.3, 0.3, 0.3, 0.3, 0.3, 0.3, 0.3, 0.3, 0.3, 0.3},
                                    {0.4, 0.4, 0.4, 0.4, 0.4, 0.4, 0.4, 0.4, 0.4, 0.4},
                                    {0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5}};

        
        double resultados[] = new double[matriz.length];
        double diferenca[] = new double[matriz.length];
        int verifica = 0;
        double soma = 0;
        double esquerdaSoma = 0;
        double direitaSoma = 0;
        double centroLinha = Integer.MAX_VALUE ;
        int centroGravidadeLinha = 0;
        
        
         //inseri resultados no array 'resultados'
         System.out.println("Soma de cada Linha da Matriz");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                soma = soma + matriz[i][j];

            }

            resultados[verifica] = soma;
            System.out.printf("[%.2f]", resultados[verifica]);
            soma = 0;
            verifica++;
        }
        System.out.println();
        

        System.out.println("Dentro das [] é a soma de cada linha , o valor após o '=' é a linha verificada \n"
                            + "a direita estão resultados das linhas acima da matriz e a esquerda resultados das linhas abaixo da matriz");
        for (int i = 0; i < resultados.length; i++) {// Linha verificada
            for (int j = i + 1; j < resultados.length; j++) {//soma das linhas abaixo da linha verificada 
                direitaSoma = direitaSoma + resultados[j];
            }
            System.out.printf("[%.2f] = %f ", direitaSoma, resultados[i]);

            for (int k = i - 1; k >= 0; k--) {//soma das linhas acima da linha verificada
                esquerdaSoma = esquerdaSoma + resultados[k];
            }
            System.out.printf("[%.2f] = %f ", esquerdaSoma, resultados[i]);
            System.out.println("");
            
            if (direitaSoma > esquerdaSoma) {//verifica qual valor é maior para ser subtraido
                diferenca[i] = direitaSoma - esquerdaSoma;// armazena os valores diferença de cada respectiva linha

            } else {
                diferenca[i] = esquerdaSoma - direitaSoma;
            }
            esquerdaSoma = 0;//zera a soma superior para verificar a proxima linha
            direitaSoma = 0;//zera a soma inferior para verificar a proxima linha
        }
        for (int i = 0; i < diferenca.length; i++) {
            
            if(diferenca[i] < centroLinha){
                centroLinha = diferenca[i];
                centroGravidadeLinha = i+1;
                
            } 
            
        }
        System.out.println( "A linha do centro de gravidade  é "+centroGravidadeLinha);
    }

}

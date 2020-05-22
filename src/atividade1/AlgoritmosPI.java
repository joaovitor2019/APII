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
      double matriz[][] = {{0.1, 0.2, 0.1, 0.2, 0.1},
                             {0.1, 0.2, 0.3, 0.1, 0.1},
                             {0.2, 0.3, 0.1, 0.1, 0.3},
                             {0.4, 0.1, 0.1, 0.1, 0.2},
                             {0.2, 0.2, 0.3, 0.3, 0.1}};
        /*double matriz[][] =        {{0.1, 0.1, 0.1, 0.1, 0.1, 0.1 , 0.1, 0.1 , 0.1 , 0.1},
                                    {0.2, 0.2, 0.2, 0.2, 0.2, 0.2, 0.2, 0.2, 0.2, 0.2},
                                    {0.3, 0.3, 0.3, 0.3, 0.3, 0.3, 0.3, 0.3, 0.3, 0.3},
                                    {0.4, 0.4, 0.4, 0.4, 0.4, 0.4, 0.4, 0.4, 0.4, 0.4},
                                    {0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5}};*/

        
        double resultadosLinhas [] = new double[matriz.length];
        double resultadosColunas [] = new double[matriz[0].length];
        double diferencaLinha [] = new double[resultadosLinhas.length];
        double diferencaColunas [] = new double [resultadosColunas.length];
        int verifica = 0;
        double soma = 0;
        double acimaSoma = 0;
        double abaixoSoma = 0;
        double centroLinha = Integer.MAX_VALUE ;
        double centroColuna = Integer.MAX_VALUE ;
        int centroGravidadeLinha = 0;
        int centroGravidadeColuna = 0;
        
         //inseri resultados no array 'resultadosLinhas'
         System.out.println("Soma de cada Linha da Matriz");
        for (double[] matriz1 : matriz) {
            for (int j = 0; j < matriz[0].length; j++) {
                soma = soma + matriz1[j];
            }
            resultadosLinhas[verifica] = soma;
            System.out.printf("[%.2f]", resultadosLinhas[verifica]);
            soma = 0;
            verifica++;
        }
        soma = 0;
        verifica = 0;
        System.out.println();
        

        System.out.println("Dentro das [] é a soma de cada linha , o valor após o '=' é a linha verificada \n"
                            + "a direita estão resultados das linhas acima da matriz e a esquerda resultados das linhas abaixo da matriz");
        for (int i = 0; i < resultadosLinhas.length; i++) {// Linha verificada
            for (int j = i + 1; j < resultadosLinhas.length; j++) {//soma das linhas abaixo da linha verificada 
                abaixoSoma = abaixoSoma + resultadosLinhas[j];
            }
            System.out.printf("[%.2f] = %f ", abaixoSoma, resultadosLinhas[i]);

            for (int k = i - 1; k >= 0; k--) {//soma das linhas acima da linha verificada
                acimaSoma = acimaSoma + resultadosLinhas[k];
            }
            System.out.printf("[%.2f] = %f ", acimaSoma, resultadosLinhas[i]);
            System.out.println("");
            
            if (abaixoSoma > acimaSoma) {//verifica qual valor é maior para ser subtraido
                diferencaLinha[i] = abaixoSoma - acimaSoma;// armazena os valores diferença de cada respectiva linha

            } else {
                diferencaLinha[i] = acimaSoma - abaixoSoma;
            }
            acimaSoma = 0;//zera a soma superior para verificar a proxima linha
            abaixoSoma = 0;//zera a soma inferior para verificar a proxima linha
        }
        for (int i = 0; i < diferencaLinha.length; i++) {
            
            if(diferencaLinha[i] < centroLinha){
                centroLinha = diferencaLinha[i];
                centroGravidadeLinha = i+1;
                
            } 
            
        }
        
       abaixoSoma = 0;
       acimaSoma = 0;
    //inseri resultados no array 'resultadosColunas'
         System.out.println("Soma de cada Coluna da Matriz");
        for (int i = 0; i< matriz[0].length;i++) {
            for (int j = 0; j < matriz.length; j++) {
                soma = soma + matriz[j][i];
            }
            resultadosColunas[verifica] = soma;
            System.out.printf("[%.2f]", resultadosColunas[verifica]);
            soma = 0;
            verifica++;
        }
        
       for (int i = 0; i < resultadosColunas.length; i++) {// Linha verificada
            for (int j = i + 1; j < resultadosColunas.length; j++) {//soma das linhas abaixo da linha verificada 
                abaixoSoma = abaixoSoma + resultadosColunas[j];
            }
            System.out.printf("[%.2f] = %f ", abaixoSoma, resultadosColunas[i]);

            for (int k = i - 1; k >= 0; k--) {//soma das linhas acima da linha verificada
                acimaSoma = acimaSoma + resultadosColunas[k];
            }
            System.out.printf("[%.2f] = %f ", acimaSoma, resultadosColunas[i]);
            System.out.println("");
            
            if (abaixoSoma > acimaSoma) {//verifica qual valor é maior para ser subtraido
                diferencaColunas[i] = abaixoSoma - acimaSoma;// armazena os valores diferença de cada respectiva linha

            } else {
                diferencaColunas[i] = acimaSoma - abaixoSoma;
            }
            acimaSoma = 0;//zera a soma superior para verificar a proxima linha
            abaixoSoma = 0;//zera a soma inferior para verificar a proxima linha
        }
        for (int i = 0; i < diferencaColunas.length; i++) {
            
            if(diferencaColunas[i] < centroColuna){
                centroColuna = diferencaColunas[i];
                centroGravidadeColuna = i+1;
                
            }
        }
        
        System.out.println( "O centro de gravidade  é {"+centroGravidadeLinha+" , "+centroGravidadeColuna+"}");
        
    }

}

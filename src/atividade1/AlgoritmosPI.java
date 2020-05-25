/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author João Vitor Alves, Caio Moreno, Gustavo Pitombeira 
 */
public class AlgoritmosPI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	
    	String arquivo = "arquivo.txt";
		double vetor[][] = criaVetor(arquivo); //passa como argumento o nome do arquivo que deseja ler a primeira linha para criar o vetor
		
		vetor = populaVetor(vetor,arquivo); // passa o vetor(ele ainda não tem nenhuma informação em seus elementos) e o arquivo novamento para ler o restante das linhas
		
		for (int i = 0; i < vetor.length; i++) 
		{
			for (int j = 0; j < vetor[i].length; j++) 
			{
				System.out.print(vetor[i][j]+ " ");
			}
			System.out.println();
		}
		 	
		
	
    	
        // TODO code application logic here
      /* double matriz[][] = {{0.1, 0.2, 0.1, 0.2, 0.1},
                             {0.1, 0.2, 0.3, 0.1, 0.1},
                             {0.2, 0.3, 0.1, 0.1, 0.3},
                             {0.4, 0.1, 0.1, 0.1, 0.2},
                             {0.2, 0.2, 0.3, 0.3, 0.1}};*/
        double matriz[][] =      {{0.1, 0.1, 0.1, 0.1, 0.1, 0.1 , 0.1, 0.1 , 0.1 , 0.1},
                                    {0.2, 0.2, 0.2, 0.2, 0.2, 0.2, 0.2, 0.2, 0.2, 0.2},
                                    {0.3, 0.3, 0.3, 0.3, 0.3, 0.3, 0.3, 0.3, 0.3, 0.3},
                                    {0.4, 0.4, 0.4, 0.4, 0.4, 0.4, 0.4, 0.4, 0.4, 0.4},
                                    {0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5}};

        
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
    
    
    
    
    // FUNÇÕES
    

public static double[][] criaVetor(String arquivo)
{
	double vetor[][] = null;
	
	try (BufferedReader br = new BufferedReader(new FileReader(arquivo)))
	{
		
		String linha1 = br.readLine(); // Passo os dados da primeira linha para minha variável
		String [] dimensoes = linha1.split(" ");//Separo os valores no meu vetor
		
		
		vetor = new double[Integer.parseInt(dimensoes[0])][Integer.parseInt(dimensoes[1])]; 
		
		
		
	} catch (IOException e) 
	{
		System.out.println("ERRO ----> "+ e.getMessage());
	}
	
	return vetor;
}

public static double[][] populaVetor(double vetor[][],String arquivo)
{
	
	
	try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) // Instancio as classes de leitura do arquivo, usei a funcao do java Try-Resources pois desta forma ele garante que os recursos serão fechados depois do try e assim não preciso usar o Finally
	{
		
		String linhas = br.readLine(); // tiro a primeira linha antes de entrar no while pois ela já foi lida para criar o vetor.
		int i =0; // para fazer o necessário eu preciso apenas percorrer o j, entao crio essa variavel e incremento no final do while após percorrer todo o J.
		
		while(true) 
		{
			linhas = br.readLine();
			
			if(linhas == null) 
			{
			//Verifico se nao vem mais informaçoes e caso nao venha, eu paro o laço
			break;
			}
			
			String [] vetorTemp = linhas.split(" "); //Separo os valores no meu vetor
			
			for (int j = 0; j < vetorTemp.length; j++) 
			{
				
				vetor[i][j] = Double.parseDouble((vetorTemp[i])); // enquanto percorre o j eu incremento os valores
			}
			
				i++; // Incremeto o I após percorrer todo o J.
			 
		}			
		
	} catch (IOException e) 
	{
		System.out.println("ERRO ----> "+ e.getMessage()); // Caso dê alguma excessão eu printo na tela
	}
	
	return vetor;
}


}

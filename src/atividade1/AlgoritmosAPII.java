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
 * @author JoÃ£o Vitor Alves, Caio Moreno, Gustavo Pitombeira
 */
public class AlgoritmosAPII {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		String arquivo = "arquivo.txt";
		double matriz[][] = criaMatriz(arquivo); // passa como argumento o nome do arquivo que deseja ler a primeira
													// linha para criar o vetor

		matriz = populaMatriz(matriz, arquivo); // passa o vetor(ele ainda não tem nenhuma informação em seus
												// elementos) e o arquivo novamento para ler o restante das linhas

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}

		double somaLinhas[] = new double[matriz.length];
		double somaColunas[] = new double[matriz[0].length];
		double resultadoSubtracaoLinhas[] = new double[somaLinhas.length];
		double resultadoSubtracaoColunas[] = new double[somaColunas.length];

		armazenaSomaLinha(matriz, somaLinhas);// inseri soma no array 'somaLinhas'
		armazenaResultadosSubtracao(somaLinhas, resultadoSubtracaoLinhas);// armazenando a subtração das somas acima e
																			// abaixo da coluna verificada

		armazenaSomaColuna(matriz, somaColunas);// inseri soma no array 'somaColunas'
		armazenaResultadosSubtracao(somaColunas, resultadoSubtracaoColunas);// armazenando a subtração das somas acima e
																			// abaixo da coluna verificada

		String resposta = CentroDeGravidade(resultadoSubtracaoLinhas, resultadoSubtracaoColunas);

		System.out.println("\n\n" + resposta);

	}
	// FUNÇÕES

	public static double[][] criaMatriz(String arquivo) {
		double matriz[][] = null;

		try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {

			String linha1 = br.readLine(); // Passo os dados da primeira linha para minha variável
			String[] dimensoes = linha1.split(" ");// Separo os valores no meu vetor

			matriz = new double[Integer.parseInt(dimensoes[0])][Integer.parseInt(dimensoes[1])];

		} catch (IOException e) {
			System.out.println("ERRO ----> " + e.getMessage());
		}

		return matriz;
	}

	public static double[][] populaMatriz(double matriz[][], String arquivo) {

		try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) { // Instancio as classes de leitura do
																				// arquivo, usei a funcao do java
																				// Try-Resources pois desta forma ele
																				// garante que os recursos serão
																				// fechados depois do try e assim não
																				// preciso usar o Finally

			String linhas = br.readLine(); // tiro a primeira linha antes de entrar no while pois ela já¡ foi lida para
											// criar o vetor.
			int i = 0; // para fazer o necessário eu preciso apenas percorrer o j, entao crio essa
						// variavel e incremento no final do while após percorrer todo o J.

			while (true) {
				linhas = br.readLine();

				if (linhas == null) {
					// Verifico se nao vem mais informações e caso nao venha, eu paro o laço
					break;
				}

				String[] vetorTemp = linhas.split(" "); // Separo os valores no meu vetor

				for (int j = 0; j < vetorTemp.length; j++) {

					matriz[i][j] = Double.parseDouble((vetorTemp[j])); // enquanto percorre o j eu incremento os
																		// valores
				}

				i++; // Incremeto o I após percorrer todo o J.

			}

		} catch (IOException e) {
			System.out.println("ERRO ----> " + e.getMessage()); // No Caso de alguma excessão eu printo na tela
		}

		return matriz;
	}

	public static void armazenaSomaLinha(double matriz[][], double somaLinhas[]) {// armazena soma da Linha
		double somaLinha = 0;
		int verificaLinha = 0;
		for (double[] matriz1 : matriz) {// Percorre a matriz em Linha
			for (int j = 0; j < matriz[0].length; j++) {
				somaLinha += matriz1[j];// armazena a soma da Linha percorrida
			}
			somaLinhas[verificaLinha] = somaLinha;// armazena o resultado obtido no Vetor

			somaLinha = 0;
			verificaLinha++;
		}

	}

	public static void armazenaSomaColuna(double matriz[][], double somaColunas[]) {// armazena soma da Coluna
		double somaColuna = 0;
		int verificaColuna = 0;
		for (int i = 0; i < matriz[0].length; i++) {// Percorre a matriz em Colunas
			for (int j = 0; j < matriz.length; j++) {
				somaColuna += matriz[j][i]; // armazena a soma da coluna percorrida
			}
			somaColunas[verificaColuna] = somaColuna;// armazena o resultado obtido no Vetor

			somaColuna = 0;
			verificaColuna++;
		}

	}

	public static void armazenaResultadosSubtracao(double[] soma, double[] resultadoSubtracao) {
		double abaixoSoma = 0;
		double acimaSoma = 0;
		for (int i = 0; i < soma.length; i++) {// Linha/Coluna verificada
			for (int j = i + 1; j < soma.length; j++) {// soma das linhas/Colunas abaixo da linha/coluna verificada
				abaixoSoma = abaixoSoma + soma[j];
			}

			for (int k = i - 1; k >= 0; k--) {// soma das linhas/Colunas acima da linha/Colunas verificada
				acimaSoma = acimaSoma + soma[k];
			}

			if (abaixoSoma > acimaSoma) {// verifica qual valor é o maior para ser subtraido
				resultadoSubtracao[i] = abaixoSoma - acimaSoma;// armazena o resultado subtraido de cada linha/Coluna
																// Verificada

			} else {
				resultadoSubtracao[i] = acimaSoma - abaixoSoma;
			}
			acimaSoma = 0;// zera a soma superior para verificar a proxima linha/Coluna
			abaixoSoma = 0;// zera a soma inferior para verificar a proxima linha/Coluna
		}
	}

	public static String CentroDeGravidade(double[] resultadoSubtracaoLinhas, double[] resultadoSubtracaoColunas) {
		double centroLinha = Integer.MAX_VALUE;
		double centroColuna = Integer.MAX_VALUE;
		int centroGravidadeLinha = 0;
		int centroGravidadeColuna = 0;

		for (int i = 0; i < resultadoSubtracaoLinhas.length; i++) {// encontra a linha do centro de gravidade

			if (resultadoSubtracaoLinhas[i] < centroLinha) {// percorre o vetor com resultados e pega o menor valor
				centroLinha = resultadoSubtracaoLinhas[i];
				centroGravidadeLinha = i + 1;

			}

		}
		for (int i = 0; i < resultadoSubtracaoColunas.length; i++) {// encontra a Coluna do centro de gravidade

			if (resultadoSubtracaoColunas[i] < centroColuna) {// percorre o vetor com resultados e pega o menor valor
				centroColuna = resultadoSubtracaoColunas[i];
				centroGravidadeColuna = i + 1;

			}
		}

		return "O centro de gravidade da Matriz é {" + centroGravidadeLinha + " , " + centroGravidadeColuna + "}";
	}

}

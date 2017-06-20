/**
  * Algoritmo Shellsort
  *
  * @author: Luiz Gustavo Braganca dos Santos
  * Matricula: 524507
  * Professor: Max do Val Machado
  *
  * @version: 0.1
  * Data da Criação: 12/09/2016
  */

import java.util.*;

public class Shellsort
{
	/**
  	  * Metodo  equals( )      - compara duas strings.
  	  * @param  String s1      - primeira string.
  	  * @param  String s2      - segunda string.
  	  * @return boolean result - resultado da comparacao.
  	  */
	public static boolean equals( String s1, String s2 )
	{
		// definir dados
		int cont = 0;
		boolean result = false;

		// ve se o tamanho eh igual
		if( s1.length( ) == s2.length( ))
		{
			// olha cada letra da string se eh igual
			for( int i = 0; i < s1.length( ); i++ )
			{
				if( s1.charAt( i ) == s2.charAt( i ))
				{
					cont++;
				}// end if
			}// end

			// se o contador for igual o tamanho da string,
			// as duas strings sao iguais
			if( cont == s2.length( ))
			{
				result = true;
			}// end if
		}// end if

		return( result );
	}// end equals( )

	public static void main( String [] args )throws Exception
	{
		// definir dados
		long    inicio, fim, tempo;
		int     id          = 0;
		int     comparacoes = 0;
		Lista   lista       = new Lista( 1000 );
		Pessoa  pessoa      = new Pessoa( );
		String  str         = "";

		// pegando o tempo
		inicio = lista.now( );

		// le uma string
		str = MyIO.readLine( );

		// lendo atributos de pessoas
		while(!( equals( str, "FIM" )))
		{
			// comparando
			comparacoes++;

			// criando nova pessoa
			pessoa = new Pessoa( );

			// lendo pessoa
			pessoa.ler( str );

			// inserindo no fim da lista
			lista.inserirFim( pessoa );

			// le uma string
			str = MyIO.readLine( );
		}// end while

		// rearranjando array
		comparacoes += lista.shellsort( );

		// pegando o tempo
		fim = lista.now( );

		// abrindo arquivo texto
    	Arq.openWrite( "524507_shellsort.txt" );

    	// calculando o tempo gasto
    	tempo = ( fim - inicio ) / 1000;

    	// escrevendo no arquivo
    	Arq.println( "524507\t" + tempo + " s\t" + comparacoes + " comparacoes" );

    	// fechando o arquivo
    	Arq.close( );
	}// end main( )
}// end class TP05Q06
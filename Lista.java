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

public class Lista extends Pessoa
{
    // definir dados
    private Pessoa[] array;
    private int n;

    /**
     * Contrutor da classe Lista.
     * @return tamanho da lista.
     */
    public Lista( )
    {
        this( 6 );
    }// end Construtor

    /**
     * Construtor da class Lista com parametros.
     * @param int tamanho - tamanho do array de pessoas.
     */
    public Lista( int tamanho )
    {
        // crindo ponteiro de pessoas
        array = new Pessoa[tamanho];

        // iniciando o contador como 0
        n = 0;
    }// end Construtor

    /**
     * Metodo inserirInicio( ) - insere uma pessoa no inicio do array e
     *                           move os demais elementos para o fim da lista.
     * @param  Pessoa pessoa   - pessoa a ser inserida na lista.
     * @throws Exception       - Se a lista estiver cheia.
     */
    public void inserirInicio( Pessoa pessoa ) throws Exception
    {
        // validar insercao
        if( n >= array.length )
        {
            throw new Exception( "Erro ao inserir!" );
        }// end if

        // leva os elementos para o fim do array
        for( int i = n; i > 0; i-- )
        {
            array[i] = array[i-1];
        }// end for

        // inserindo no inicio
        array[0] = pessoa;

        // incrementando o contador
        n++;
    }// end inserirInicio( )

    /**
     * Metodo inserirFim( )  - insere no fim do array de pessoas.
     * @param  Pessoa pessoa - pessoa a ser inserida.
     * @throws Exception     - Se a lista estiver cheia.
     */
    public void inserirFim( Pessoa pessoa ) throws Exception
    {
        // validar insercao
        if( n >= array.length )
        {
            throw new Exception( "Erro ao inserir!" );
        }// end if

        // inserindo na ultima posicao
        array[n] = pessoa;

        // incrementando o contador
        n++;
    }//end inserirFim( )

    /**
     * Metodo inserir( ) - insere elemento em uma posicao especifica e
     *                     move os elementos para o fim da lista.
     * @param  pessoa    - pessoa a ser inserida.
     * @param  pos       - posicao de insercao.
     * @throws Exception - Se a lista estiver cheia ou a posicao invalida.
     */
    public void inserir( Pessoa pessoa, int pos ) throws Exception
    {
        // validar insercao
        if( n >= array.length || pos < 0 || pos > n )
        {
            throw new Exception( "Erro ao inserir!" );
        }// end if

        // levar elementos para o fim do array
        for( int i = n; i > pos; i-- )
        {
            array[i] = array[i-1];
        }// end for

        // inserindo na posicao desejada
        array[pos] = pessoa;

        // incrementando o contador
        n++;
    }// end inserir( )

    /**
     * Metodo removerInicio( ) - remove um elemento do inicio e
     *                              movimenta os demais para o inicio.
     * @return Pessoa result   - elemento a ser removido.
     * @throws Exception       - Se a lista estiver vazia.
     */
    public Pessoa removerInicio( ) throws Exception
    {
        // validar remocao
        if( n == 0 )
        {
            throw new Exception( "Erro ao remover!" );
        }// end if

        // definir dados
        Pessoa result = array[0];

        // decrementa o contador
        n--;

        // leva os elementos para o inicio
        for( int i = 0; i < n; i++ )
        {
            array[i] = array[i+1];
        }// end for

        return( result );
    }// end removerInicio( )

    /**
     * Metodo removerFim( )  - remove elemento do fim.
     * @return Pessoa result - elemento a ser removido.
     * @throws Exception     - Se a lista estiver vazia.
     */
    public Pessoa removerFim( ) throws Exception
    {
        // validar remocao
        if( n == 0 )
        {
            throw new Exception( "Erro ao remover!" );
        }// end if

        // removendo e retornando ultimo elemento
        return( array[--n] );
    }// end removerFim( )

    /**
     * Metodo remover( )     - remove um elemento de uma posicao especifica e
     *                         movimenta os demais para o inicio da lista.
     * @param  int    pos    - posicao de remocao.
     * @return Pessoa result - elemento removido.
     * @throws Exception     - Se a lista estiver vazia ou posicao invalida.
     */
    public Pessoa remover( int pos ) throws Exception
    {
        // validar remocao
        if( n == 0 || pos < 0 || pos >= n )
        {
            throw new Exception( "Erro ao remover!" );
        }// end if

        // pegando o elemento a ser removido na posicao especifica
        Pessoa result = array[pos];

        // decrementa o contador
        n--;

        // movimenta o array para o inicio.
        for( int i = pos; i < n; i++ )
        {
            array[i] = array[i+1];
        }// end for

        return( result );
    }// end remover( )

    /**
     * Metodo mostrar( ) - mostra elementos da lista.
     */
    public void mostrar( )
    {
        for( int i = 0; i < n; i++ )
        {
            MyIO.println( array[i].imprimir( ));
        }// end for
    }// end mostrar( )

    /**
     * Metodo pesquisar( ) - procura um elemento e retorna se ele existe.
     * @param  double id   - elemento a ser pesquisado.
     * @return <code>true</code>  se o array existir,
     *         <code>false</code> em caso contrario.
     */
    public boolean pesquisar( int id )
    {
        // definir dados
        boolean result = false;

        // procurando elemento no array
        for( int i = 0; i < n && result == false; i++ )
        {
            result = ( array[i].getId( ) == id );
        }// end for

        return( result );
    }// end pesquisar( )

    /**
     * Metodo shellsort( ).
     * @return int comparacoes.
     */
    public int shellsort( )
    {
        // definir dados
        int comparacoes = 0;
        int h           = 1;

        do
        {
            // achando quantas cores usara'
            h = ( h * 3 ) + 1;

            // comparando
            comparacoes++;
        }while( h < n );

        do
        {
            // dividindo por 3
            h /= 3;

            for( int cor = 0; cor < h; cor++ )
            {
                // comparando
                comparacoes++;

                // chamando a insercao por cores
                comparacoes += insercaoPorCor( cor, h );
            }// end for

            // comparando
            comparacoes++;
        }while( h != 1 );

        // mostrando os elementos
        mostrar( );

        return( comparacoes );
    }// end shellsort( )

    /**
     * Metodo insercaoPorCor( ).
     * @param  int cor        - cores no array.
     * @param  int h          - quantidade de grupos de cores.
     * @return int coparacoes - comparacoes
     */
    public int insercaoPorCor( int cor, int h )
    {
        // definir dados
        int j = 0;
        int comparacoes = 0;

        // rearranjando o array de pessoas
        for( int i = ( h + cor ); i < n; i += h )
        {
            // comparando
            comparacoes++;

            // criando temporario
            Pessoa tmp = array[i];

            // achando o j
            j = i - h;

            // arrumando o array conforme as datas de nascimento
            while(( j >= 0 ) && ( array[j].getNascimento( ).compareTo( tmp.getNascimento( )) > 0 ))
            {
                // comparando
                comparacoes++;

                // trocando pessoas
                array[j+h] = array[j];

                // decrementando o j
                j -= h;
            }// end while
            array[j+h] = tmp;
        }// end for

        return( comparacoes );
    }// end insercaoPorCor( )

    /**
     * Metodo imprimeDia( ) - imprime as datas de nascimento.
     */
    public void imprimeDia( )
    {
        for( int i = 0; i < n; i++ )
        {
            MyIO.println( array[i].getNascimento( ));
        }// end for
    }// end imprimeDia( )

    /**
     * Retorna o timestamp atual
     * @return timestamp atual
     */
    public static long now( )
    {
      return new Date( ).getTime( );
    }// end now( )
}// end class Lista
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

public class Pessoa
{
    // definir dados globais
    private int id;
    private int idade;
    private String nome;
    private String nacionalidade;
    private String nascimento;
    private String localNascimento;
    private String morte;
    private String localMorte;

    /**
     * Metodo Construtor de Pessoa sem parametros.
     */
    public Pessoa( )
    {
        // inicializando variaveis
        this.id = 0;
        this.idade = 0;
        this.nome = "";
        this.nacionalidade = "";
        this.nascimento = "";
        this.localNascimento = "";
        this.morte = "";
        this.localMorte = "";
    }// end contrutor( )

    /**
     * Metodo Construtor de Pessoa com parametros.
     * @param int    id              - id da pessoa.
     * @param int    idade           - idade da pessoa.
     * @param String nome            - nome da pessoa.
     * @param String nacionalidade   - nacionalidade.
     * @param String nascimento      - data de nascimento
     * @param String localNascimento - local onde nasceu.
     * @param String morte           - data da morte.
     * @param String localMorte      - local onde morreu.
     */
    public Pessoa( int id, int idade, String nome, String nacionalidade, String nascimento,
                   String localNascimento, String morte, String localMorte )
    {
        // inicializando variaveis
        this.id              = id;
        this.idade           = idade;
        this.nome            = nome;
        this.nacionalidade   = nacionalidade;
        this.nascimento      = nascimento;
        this.localNascimento = localNascimento;
        this.morte           = morte;
        this.localMorte      = localMorte;
    }// end contrutor( )

    /**
     * Metodo setId( ).
     * @param int id.
     */
    public void setId( int id )
    {
        this.id = id;
    }// end setId( )

    /**
     * Metodo setIdade( ).
     * @param int idade.
     */
    public void setIdade( int idade )
    {
        this.idade = idade;
    }// end setIdade( )

    /**
     * Metodo setNome( ).
     * @param String nome.
     */
    public void setNome( String nome )
    {
        this.nome = nome;
    }// end setNome( )

    /**
     * Metodo setNacionalidade( ).
     * @param String nacionalidade.
     */
    public void setNacionalidade( String nacionalidade )
    {
        this.nacionalidade = nacionalidade;
    }// end setNacionalidade( )

    /**
     * Metodo setNascimento( ).
     * @param String nascimento.
     */
    public void setNascimento( String nascimento )
    {
        this.nascimento = nascimento;
    }// end setnascimento( )

    /**
     * Metodo setLocalNascimento( ).
     * @param String localNascimento.
     */
    public void setLocalNascimento( String localNascimento )
    {
        this.localNascimento = localNascimento;
    }// end setLocalNascimento( )

    /**
     * Metodo setMorte( ).
     * @param String morte.
     */
    public void setMorte( String morte )
    {
        this.morte = morte;
    }// end setmorte( )

    /**
     * Metodo setLocalMorte( ).
     * @param String localMorte.
     */
    public void setLocalMorte( String localMorte )
    {
        this.localMorte = localMorte;
    }// end setLocalMorte( )

    /**
     * Metodo getId( ).
     * @return int id.
     */
    public int getId( )
    {
        return( this.id );
    }// end getId( )

    /**
     * Metodo getIdade( ).
     * @return int idade.
     */
    public int getIdade( )
    {
        return( this.idade );
    }// end getIdade( )

    /**
     * Metodo getNome( ).
     * @return String nome.
     */
    public String getNome( )
    {
        return( this.nome );
    }// end getNome( )

    /**
     * Metodo getNacionalidade( ).
     * @return String nacionalidade.
     */
    public String getNacionalidade( )
    {
        return( this.nacionalidade );
    }// end getNacionalidade( )

    /**
     * Metodo getNascimento( ).
     * @return String nascimento.
     */
    public String getNascimento( )
    {
        return( this.nascimento );
    }// end getnascimento( )

    /**
     * Metodo getLocalNascimento( ).
     * @return String localNascimento.
     */
    public String getLocalNascimento( )
    {
        return( this.localNascimento );
    }// end getLocalNascimento( )

    /**
     * Metodo getMorte( ).
     * @return String morte.
     */
    public String getMorte( )
    {
        return( this.morte );
    }// end getmorte( )

    /**
     * Metodo getLocalMorte( ).
     * @return String localMorte.
     */
    public String getLocalMorte( )
    {
        return( this.localMorte );
    }// end getLocalMorte( )

    /**
     * Metodo clone( ).
     * @return Pessoa pessoa.
     * @throws CloneNotSupportedException.
     */
    public Pessoa clone( )
    {
        // criando objeto da classe
        Pessoa pessoa = new Pessoa( );

        // criando clones
        pessoa.setId( this.id );
        pessoa.setIdade( this.idade );
        pessoa.setNome( this.nome );
        pessoa.setNacionalidade( this.nacionalidade );
        pessoa.setNascimento( this.nascimento );
        pessoa.setLocalNascimento( this.localNascimento );
        pessoa.setMorte( this.morte );
        pessoa.setLocalMorte( this.localMorte );

        return( pessoa );
    }// end clone( )

    /**
     * Metodo removeTags( ) - remove as tags html.
     * @param  String str    - String a ser analisada.
     * @return String result - retorna uma string sem tags html.
     */
    public String removeTags( String str )
    {
        // definir dados
        String result = "";

        // anda na string toda
        for( int i = 0; i < str.length( ); i++ )
        {
            // olha a primeira tag
            while( i < str.length( ) && str.charAt( i ) == '<' )
            {
                // despreza a tag
                for( i++; str.charAt( i ) != '>'; i++ );
                i++;

                while( i < str.length( ) && str.charAt( i ) == '&' )
                {
                    for( i++; str.charAt( i ) != ';'; i++ );
                    i++;
                }// end while
            }// end while

            while( i < str.length( ) && str.charAt( i ) == '&' )
            {
                for( i++; str.charAt( i ) != ';'; i++ );
                i++;
                result += ' ';
            }// end while

            if( i < str.length( ))
            {
                result += str.charAt( i );
            }// end if
        }// end for

        while( result.length( ) > 0 && result.charAt( 0 ) == ' ' )
        {
            result = result.substring( 1 );
        }// end while

        return( result );
    }// end removeTags( )

    /**
     * Metodo parsePessoa( ).
     * @param s - string a ser analisada.
     */
    public void parsePessoa( String s )
    {
      String array[]       = s.split( " ## " );
      this.id              = new Integer( array[0] ).intValue( );
      this.nome            = array[1];
      this.nacionalidade   = array[2];
      this.nascimento      = array[3];
      this.localNascimento = array[4];
      this.morte           = array[5];
      this.localMorte      = array[6];
      this.idade           = new Integer( array[7] ).intValue( );
    }// end parsePessoa( )

    /**
     * Metodo getSubstringEntre( ) - pega a substring entre duas strings.
     * @param  String str    - String a ser analisada.
     * @param  String antes  - string antes.
     * @param  String depois - string depois.
     * @return String result - retorna a substring.
     */
    public String getSubstringEntre( String str, String antes, String depois )
    {
        // definir dados
        String result = "";
        int posInicio, posFim;

        // pegando a posicao do inicio
        posInicio = str.indexOf( antes ) + antes.length( );

        // testa se o antes eh diferente do depois
        if( antes.compareTo( depois ) != 0 )
        {
            posFim = str.indexOf( depois );
        }
        else
        {
            posFim = str.indexOf( depois, posInicio );
        }// end if

        // pegando a substring
        if( 0 <= posInicio && posInicio < posFim && posFim < str.length( ))
        {
            result = str.substring( posInicio, posFim );
        }// end if

        return( result );
    }// end getSubstringEntre( )

    /**
     * Metodo getIntEntre( )
     * @param  String s      - string analisada.
     * @param  String antes  - o que tem antes.
     * @param  String depois - o que tem depois.
     * @return retorna um valor inteiro.
     */
    public int getIntEntre( String s, String antes, String depois )
    {
      return( new Integer( getSubstringEntre( s, antes, depois ).replace( ".", "" ).trim( ))).intValue( );
    }// end getIntEntre( )

    /**
     * Metodo getDoubleEntre( ).
     * @param  String s      - string analisada.
     * @param  String antes  - o que tem antes.
     * @param  String depois - o que tem depois.
     * @return retorna um valor real.
     */
    public double getDoubleEntre( String s, String antes, String depois )
    {
      return( new Double( getSubstringEntre( s, antes, depois ).replace( ",", "." ).trim( ))).doubleValue( );
    }// end getDoubleEntre( )

    /**
     * Metodo  getMes( )     - analisa os meses.
     * @param  String data   - string a ser analisada.
     * @return int    result - retorna um inteiro correspondente.
     */
    public int getMes( String data )
    {
        // definir dados
        int result = 0;

        // testa os meses
        if( data.contains( "janeiro" ) == true ){
            result = 1;
        } else if( data.contains( "fevereiro" ) == true ){
            result = 2;
        } else if( data.contains( "março" ) == true ){
            result = 3;
        } else if( data.contains( "abril" ) == true){
            result = 4;
        } else if( data.contains( "maio" ) == true){
            result = 5;
        } else if( data.contains( "junho" ) == true){
            result = 6;
        } else if( data.contains( "julho" ) == true){
            result = 7;
        } else if( data.contains( "agosto" ) == true){
            result = 8;
        } else if( data.contains( "setembro" ) == true){
            result = 9;
        } else if( data.contains( "outubro" ) == true){
            result = 10;
        } else if( data.contains( "novembro" ) == true){
            result = 11;
        } else if( data.contains( "dezembro" ) == true ){
            result = 12;
        }// end if

        return( result );
    }// end getMes( )

    /**
     * Metodo ler( )     - le um arquivo HTML.
     * @param String arq - nome do arquivo HTML.
     */
    public void ler( String arq )
    {
        // definir dados
        String linha;

        // abrindo arquivo
        Arq.openRead( arq, "UTF8" );

        // procurando o atributo id
        this.id =  ( arq.charAt( arq.length( ) - 8 ) - 48 ) * 100;
        this.id += ( arq.charAt( arq.length( ) - 7 ) - 48 ) *  10;
        this.id += ( arq.charAt( arq.length( ) - 6 ) - 48 );

        // procurando linha da nome
        for( linha = Arq.readLine( ); linha.contains( "<h1") == false; linha = Arq.readLine( ));
        this.nome = getSubstringEntre( linha, "lang=\"pt\">", "</h1>" );

        // procurando linha da nacionalidade
        for( linha = Arq.readLine( ); linha.contains( "Nacionalidade" ) == false; linha = Arq.readLine( ));
        this.nacionalidade = removeTags( Arq.readLine( ));

        // procurando linha de nascimento
        for( linha = Arq.readLine( ); linha.contains( "Nascimento" ) == false; linha = Arq.readLine( ));
        this.nascimento = removeTags( Arq.readLine( ));

        // testa se a pessoa esta viva
        if( this.nascimento.charAt( this.nascimento.length( ) - 1 ) == ')' )
        {
            String tmp = this.nascimento.substring( this.nascimento.indexOf( '(' ) + 1 );

            tmp = tmp.substring( 0, tmp.indexOf( ' ' ));

            this.idade      = ( new Integer( tmp )).intValue( );
            this.nascimento = this.nascimento.substring( 0, this.nascimento.indexOf( '(' ));
            this.morte      = "vivo";
            this.localMorte = "vivo";
        }
        else
        {
            this.morte      = "";
            this.localMorte = "";
        }// end if

        // procurando o local de nascimento
        for( linha = Arq.readLine( ); linha.contains( "Local" ) == false; linha = Arq.readLine( ));
        this.localNascimento = removeTags( Arq.readLine( ));

        // procurando o atributo morte e local de morte
        if( this.morte.length( ) == 0 )
        {
            for( linha = Arq.readLine( ); linha.contains( "Morte" ) == false; linha = Arq.readLine( ));
            this.morte = removeTags( Arq.readLine( ));

            if( this.morte.contains( "(" ) == true )
            {
                String tmp = this.morte.substring( this.morte.indexOf( '(' ) + 1 );
                tmp = tmp.substring( 0, tmp.indexOf( ' ' ));

                this.idade = ( new Integer( tmp )).intValue( );
                this.morte = this.morte.substring( 0, this.morte.indexOf( '(' ));
            }// end if

            for( linha = Arq.readLine( ); linha.contains( "Local" ) == false; linha = Arq.readLine( ));
            this.localMorte = removeTags( Arq.readLine( ));
        }// end if

        // fechando o arquivo
        Arq.close( );
    }// end ler( )

    /**
     * Metodo imprimir( ).
     */
   public String imprimir( )
   {
    // imprimindo dados da pessoa
      String saida = this.getId( )              + " ## " + this.getNome( )       + " ## " +
                     this.getNacionalidade( )   + " ## " + this.getNascimento( ) + " ## " +
                     this.getLocalNascimento( ) + " ## " + this.getMorte( )      + " ## " +
                     this.getLocalMorte( )      + " ## " + this.getIdade( )      + "";

      return( saida );
   }// end imprimir( )
}// end class pessoa
import java.util.*;
import java.io.* ;

public class FreqDict {

    private HashMap<String, Integer> freqDict = new HashMap<String, Integer>() ;
    private int formatWordLength = 5;

    public void add( String word ) {
        int i = 0 ;

        if ( freqDict.containsKey( word ) ) {
            i = freqDict.get( word ) ;
            i++;
            freqDict.put( word, i ) ;
        }
        else {
            freqDict.put( word, 1 ) ;
        }

        if ( word.length() > formatWordLength ) {
            formatWordLength = word.length() ;
        }
    }

    public void fill( String fileName ) {
        String line ;
        String[] words ;

        try {
            FileReader file = new FileReader( fileName ) ;
            BufferedReader buffer = new BufferedReader( file ) ;

            while ( ( line = buffer.readLine() ) != null ) {
                line = line.replaceAll( "\\p{Punct}", "" ).toLowerCase().strip() ;

                if ( ( line != "" )  && ( line != " " ) ) {
                    words = line.split( " " ) ;

                    for ( String word : words ) {
                        add( word ) ;
                    }
                }
            }
        }
        catch ( IOException e ) {
            System.out.print( " [ Ошибка ] Файл не найден " );
            System.exit( 0 ) ;
        }

    }

    public void print() {
        Set<String> keys = freqDict.keySet() ;
        ArrayList<String> sortedKeys = new ArrayList<>( keys ) ;
        Collections.sort( sortedKeys ) ;
        int n = formatWordLength + 3 ;

        System.out.println( String.format( "%-" + n + "s", "Слово" ) + "Частота" ) ;
        System.out.println( "-".repeat( n + 7 ) ) ;
        for ( String key : sortedKeys ) {
            System.out.println( String.format( "%-" + n + "s", key ) + freqDict.get( key ) ) ;
        }
    }
}
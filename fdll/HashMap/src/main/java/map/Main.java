public class Main {
    static FreqDict freqDict = new FreqDict() ;

    public static void main( String[] args ) {
        
        if ( args.length == 0 ) {
            System.out.println( " [ Ошибка ] Формат: java -jar Main.java <Имя сканируемого файла> " ) ;
        }
        else {
            String fileName = args[0] ;

            freqDict.fill( fileName ) ;
            freqDict.print() ;
        }
    }
}
import java.io.* ;

public class Main {
    public static LList lst = new LList() ;

    public static void listAdd( Object o ) {
        lst.add( o ) ;
    }

    public static Object listGet( int n ) {
        return lst.get( n ) ;
    }

    public static void listRemove( int n ) {
        lst.remove( n ) ;
    }

    public static void listPrint() {
        lst.print() ;
    }

    public static int listSize() {
        return lst.size() ;
    }

    public static void main( String[] args ) {
        Command[] cmds = { new AddCommand(), new GetCommand(), new RemoveCommand(), new PrintCommand(), new SizeCommand(), new ExitCommand() } ;
        
        Console cnsl = System.console() ;
        String input ;

        System.out.println( "\n [ Команды: ADD, GET, REMOVE, PRINT, SIZE, EXIT ] " ) ;
        System.out.println( " [ Введите команду ] " ) ;

        do {
            // Ввод команды
            input = cnsl.readLine( " >> " ) ;
            input = input.strip().toUpperCase() ;

            // Поиск команды в cmds
            for ( int i = 0 ; i < cmds.length ; i++ ) {

                if ( cmds[i].name().equals( input ) ) {
                    cmds[i].exec() ;
                    break ;
                }
                
                // Конец массива, break не сработал - неизвестная команда
                if ( i == cmds.length - 1 ) {
                    System.out.println( " [ Неизвестная команда ] " ) ;
                }
            } 
        } while ( true ) ;
    }
}
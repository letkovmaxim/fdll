import java.io.* ;
import Exception.NoSuchElementException ;

public class GetCommand implements Command {
    public String name() {
        return "GET" ;
    }

    public void exec() {
        Console cnsl = System.console() ;
        String input ;

        input = cnsl.readLine( " [ Получить элемент с номером ] >> ") ;
        try {
            System.out.println( " [ Полученный элемент - " + Main.listGet( Integer.parseInt( input ) ) + " ] " ) ;
        }
        catch ( NoSuchElementException e ) {
            e.getExceptionMessage() ;
        }
    }
}
import java.io.* ;
import Exception.NoSuchElementException ;

public class RemoveCommand implements Command {
    public String name () {
        return "REMOVE" ;
    }

    public void exec () {
        Console cnsl = System.console() ;
        String input ;

        input = cnsl.readLine( " [ Удалить элемент с номером ] >> ") ;
        try {
            Main.listRemove( Integer.parseInt( input ) ) ;
            System.out.println( " [ Элемент удален ] " ) ;
        }
        catch ( NoSuchElementException e ) {
            e.getExceptionMessage() ;
        }
    }
}
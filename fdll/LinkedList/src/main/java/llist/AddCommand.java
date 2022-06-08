import java.io.* ;

public class AddCommand implements Command {
    public String name() {
        return "ADD" ;
    }

    public void exec() {
        Console cnsl = System.console() ;
        String input ;

        input = cnsl.readLine( " [ Добавить элемент ] >> ") ;
        Main.listAdd( input ) ;
        System.out.println( " [ Элемент добавел в конец списка ] " ) ;
    }
}
public class PrintCommand implements Command {
    public String name () {
        return "PRINT" ;
    }

    public void exec () {
        if (Main.lst.size() == 0) {
            System.out.println( " [ Список пуст ] " ) ;
        }
        else {
            System.out.print( " [ Список - " ) ;
            Main.listPrint() ;
            System.out.println( " ] " ) ;
        }
    }
}
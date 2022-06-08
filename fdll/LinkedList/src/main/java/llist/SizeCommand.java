public class SizeCommand implements Command {
    public String name () {
        return "SIZE" ;
    }

    public void exec () {
        System.out.println( " [ Размер списка - " + Main.listSize() + " ] " ) ;
    }
}
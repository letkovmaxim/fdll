import Exception.NoSuchElementException ;

public class LList {

    private class Node {
        Object data ;
        Node next ;

        public Node( Object data ) {
            this.data = data ;
            this.next = null ;
        }

        public Node() {
            this.data = null ;
            this.next = null ;
        }
    }
    
    private Node root ;
    private int listSize = 0 ;

    // Не нужно
    // public void addFirst( Object data ) {
    //     Node node = new Node( data ) ; 

    //     // Вставляем в начало
    //     if ( root != null ) {
    //         node.next = root ;
    //     }

    //     root = node ;
    //     listSize++ ;
    // }
    

    // addLast
    public void add( Object data ) {
        Node node = new Node( data ) ;

        if ( root != null ) {
            // Ищем последний
            Node p = root ;
            while ( p.next != null ) {
                p = p.next ;
            }
            // Вставляем в конец
            p.next = node ;
        } else {
            root = node ;
        }

        listSize++ ;
    }

    public Object get( int n ) throws NoSuchElementException {
        int i = 0 ;
        Node p = root ;

        if ( ( n >= 0 ) && ( n < listSize ) ) {
            // Ищем нужный элемент
            while ( i < n ) {
                p = p.next ;
                i++ ;
            }
        } 
        else {
            throw new NoSuchElementException( " [ Ошибка: такого элемента нет ] " ) ;
        }
        return p.data ;
    }

    public void remove ( int n ) throws NoSuchElementException {
        int i = 0 ;
        Node p = root ;      // Тот, который нужно удалить
        Node prev = new Node() ;   // Его предыдущий

        if ( ( n >= 0 ) && ( n < listSize ) ) {
            // Ищем нужный элемент
            while ( i < n ) {
                prev = p ;
                p = p.next ;
                i++ ;
            }

            // Если удаляем root
            if ( n == 0 ) {
                root = p.next ; // root == null, если listSize = 1
            } else { // Удаляем не root, значит, предыдущий есть
                prev.next = p.next ;
            }

            p = null ; //  Сборщик мусора удалит его
            listSize-- ;
        } 
        else {
            throw new NoSuchElementException( " [ Ошибка: такого элемента нет ] " ) ;
        }
    }

    public int size() {
        return listSize ;
    }

    public void print() {
        Node node = root;
        int i = 0 ;

        while (node != null) {
            if ( i < listSize - 1 ) {
                System.out.print(node.data + ", ");
            }
            else {
                System.out.print(node.data);
            }

            i++ ;
            node = node.next;
        }
    }
}
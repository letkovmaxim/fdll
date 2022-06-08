package Exception ;

public class NoSuchElementException extends RuntimeException {
    String message;

    public NoSuchElementException() {}

    public NoSuchElementException(String msg) {
        this.message = msg;
    }

    public void getExceptionMessage() {
        System.out.println( message );
    }
}
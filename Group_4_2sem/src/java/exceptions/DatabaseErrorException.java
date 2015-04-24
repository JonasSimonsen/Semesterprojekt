package exceptions;


public class DatabaseErrorException extends Exception {

    public DatabaseErrorException () {
    
    }
    
    public DatabaseErrorException (String message) {
        super(message);
    }
    
}

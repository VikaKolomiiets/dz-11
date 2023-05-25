package exceptions;

public class OutOfRangeException extends IllegalArgumentException{
    public OutOfRangeException(String s) {
        super(" is out of the range of dates.");
    }
}

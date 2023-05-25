package exceptions;

public class StringNullException extends NullPointerException{
    public StringNullException(String s) {
        super(s + " can not be a null");
    }
}

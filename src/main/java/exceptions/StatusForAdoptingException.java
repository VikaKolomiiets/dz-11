package exceptions;

public class StatusForAdoptingException extends IllegalArgumentException{
    public StatusForAdoptingException(String s1, String s2 ) {
        super(s1 + s2 +"Status have to be 'Married' for adopting child");
    }
}

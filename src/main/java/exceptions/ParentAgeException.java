package exceptions;

public class ParentAgeException extends IllegalArgumentException{
    public ParentAgeException(String s1, String s2) {
        super("Dear "+s1+ " " + s2 + " both Parent have to be more than 18 years old.");
    }
}

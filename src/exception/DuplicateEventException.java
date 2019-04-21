package exception;

public class DuplicateEventException extends RuntimeException {
    public DuplicateEventException() {
        super("Такое событие уже существует");
    }
}
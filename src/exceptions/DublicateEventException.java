package exceptions;

public class DublicateEventException extends RuntimeException {
    DublicateEventException() {
        super("Такое событие уже существует");
    }
}

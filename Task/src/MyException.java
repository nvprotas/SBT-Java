public class MyException extends Throwable {

    private final Throwable throwable;

    public MyException(Throwable throwable) {
        this.throwable = throwable;
    }

    public Throwable getThrowable() {
        return throwable;
    }
}


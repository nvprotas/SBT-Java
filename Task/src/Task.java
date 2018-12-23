import java.util.concurrent.Callable;

public class Task<T> {

    private Callable<T> callable;
    private volatile T result;
    private volatile MyException exception;
    private boolean isDone;


    public Task(Callable<T> callable) {
        this.callable = callable;
    }

    public T get() throws MyException{
        if(isDone)
        {
            if (exception!=null) {
                throw exception;
            }
            return result;
        }
        synchronized (this) {
            if (!isDone) {
                try {
                    result = callable.call();
                } catch (Exception e) {
                    exception =new MyException(e);
                }
                isDone = true;
            }
            if (exception!=null) {
                throw exception;
            }
            return result;
        }
    }
}
